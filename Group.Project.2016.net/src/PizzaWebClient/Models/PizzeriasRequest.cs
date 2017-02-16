using System.Collections.Generic;

namespace PizzaWebClient.Models
{
    public class PizzeriasRequest
    {
        public decimal Latitude { get; set; }

        public decimal Longitude { get; set; }

        public int? MinSize { get; set; }

        public int? MaxSize { get; set; }

        public ICollection<string> IngredientsSelected { get; set; }
    }
}
