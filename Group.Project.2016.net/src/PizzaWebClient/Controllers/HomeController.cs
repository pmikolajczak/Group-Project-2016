using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using System.Net.Http;

namespace PizzaWebClient.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public async Task<IActionResult> GetIngredients()
        {
            using (var client = new HttpClient())
            {
                using (var response = await client.GetAsync("http://pizzabyapi.azurewebsites.net/api/Ingredients"))
                {
                    return Json(await response.Content.ReadAsStringAsync());
                }
            }
        }
    }
}
