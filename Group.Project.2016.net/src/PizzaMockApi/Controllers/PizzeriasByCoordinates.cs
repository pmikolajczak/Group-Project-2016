using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using PizzaModels.Models;
using PizzaMockApi.MockData;
using GeoCoordinatePortable;

namespace PizzaMockApi.Controllers
{
    [Route("api/[controller]")]
    public class PizzeriasByCoordinates : Controller
    {
        [HttpGet]
        public IEnumerable<Pizzeria> Get([FromQuery] double latitude, [FromQuery] double longitude, [FromQuery] double distance)
        {
            GeoCoordinate coords = new GeoCoordinate(latitude, longitude);

            return PizzeriasData.GetPizzeriasMockData().Where(x => x.Coordinates.GetDistanceTo(coords) <= distance);
        }
    }
}
