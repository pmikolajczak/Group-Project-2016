using System.Collections.Generic;
using GeoCoordinatePortable;

namespace PizzaModels.Models
{
    public class Pizzeria
    {
        public int Id { get; set; }

        public string Name { get; set; }

        public GeoCoordinate Coordinates { get; set; }

        public List<Pizza> Pizzas { get; set; } 
    }
}
