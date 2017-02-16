using System.Collections.Generic;

namespace PizzaWebClient.Models
{
    public class PizzeriasResponse
    {
        public int PizzeriaID { get; set; }

        public string Name { get; set; }

        public string Address { get; set; }

        public string Phone { get; set; }

        public decimal Latitude { get; set; }

        public decimal Longitude { get; set; }

        public int SizeMin { get; set; }

        public int SizeMax { get; set; }

        public int PriceMin { get; set; }

        public int PriceMax { get; set; }

        public decimal Distance { get; set; }

        public ICollection<PizzaResponse> Pizzas { get; set; }
    }
}
