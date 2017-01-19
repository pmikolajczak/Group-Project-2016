using System.Collections.Generic;
using PizzaModels.Enums;

namespace PizzaModels.Models
{
    public class Pizza
    {
        public int Id { get; set; }

        public string Name { get; set; }

        public double Price { get; set; }

        public double Diameter { get; set; }

        public List<Ingredients> Ingredients { get; set; }
    }
}
