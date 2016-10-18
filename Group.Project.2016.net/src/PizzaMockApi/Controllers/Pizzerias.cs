using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using PizzaModels.Models;
using PizzaMockApi.MockData;

namespace PizzaMockApi.controllers
{
    [Route("api/[controller]")]
    public class Pizzerias : Controller
    {
        [HttpGet]
        public IEnumerable<Pizzeria> Get()
        {
            return PizzeriasData.GetPizzeriasMockData();
        }
    }
}
