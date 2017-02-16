using System.Collections.Generic;

namespace PizzaWebClient.Models
{
    public class PizzaResponse
    {
        public int PizzaID { get; set; }

        public string Name { get; set; }

        public int Price { get; set; }

        public int Size { get; set; }

        public ICollection<Ingredient> Ingredients { get; set; }

        public int PizzeriaID { get; set; }
    }
}
