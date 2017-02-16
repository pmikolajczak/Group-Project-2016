using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using System.Net.Http;
using PizzaWebClient.Models;
using System.Collections.Generic;
using System.Globalization;

namespace PizzaWebClient.Controllers
{
    public class PizzeriasController : Controller
    {
        private string PizzeriasApiUrl = "http://pizzabyapi.azurewebsites.net/api/Pizzerias?latitude={0}&longitude={1}";
        private const string IngredientString = "&ingredientCollection={0}";

        public async Task<IActionResult> Pizzerias([FromQuery]PizzeriasRequest request)
        {
            var model = await GetPizzeriasResponse(request);

            return View(model);
        }

        private async Task<ICollection<PizzeriasResponse>> GetPizzeriasResponse(PizzeriasRequest request)
        {
            PizzeriasApiUrl = string.Format(PizzeriasApiUrl, request.Latitude.ToString(new CultureInfo("en-US")), request.Longitude.ToString(new CultureInfo("en-US")));
            PizzeriasApiUrl += GetCollectionString(request.IngredientsSelected);
            PizzeriasApiUrl += request.MinSize.HasValue ? "&minSize=" + request.MinSize.Value.ToString() : string.Empty;
            PizzeriasApiUrl += request.MaxSize.HasValue ? "&maxSize=" + request.MaxSize.Value.ToString() : string.Empty;

            using (var client = new HttpClient())
            {
                using (var response = await client.GetAsync(PizzeriasApiUrl))
                {
                    response.EnsureSuccessStatusCode();

                    return await response.Content.ReadAsAsync<ICollection<PizzeriasResponse>>();
                }
            }
        }

        private static string GetCollectionString(ICollection<string> items)
        {
            var returnString = string.Empty;

            foreach(var item in items)
            {
                returnString += string.Format(IngredientString, item);
            }

            return returnString;
        }
    }
}
