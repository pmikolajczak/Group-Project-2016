using System.Collections.Generic;
using PizzaModels.Models;

namespace PizzaMockApi.MockData
{
    public static class PizzeriasData
    {
        public static List<Pizzeria> GetPizzeriasMockData()
        {
            return new List<Pizzeria>
            {
                new Pizzeria
                {
                    Id = 1,
                    Name = "Test pizzeria 1",
                    Coordinates = new GeoCoordinatePortable.GeoCoordinate(54.356597, 18.646271),
                    Pizzas = new List<Pizza>
                    {
                        new Pizza
                        {
                            Id = 1,
                            Name = "basic 1",
                            Ingredients = new List<PizzaModels.Enums.Ingredients>
                            {
                                PizzaModels.Enums.Ingredients.Cheese,
                                PizzaModels.Enums.Ingredients.Ham,
                                PizzaModels.Enums.Ingredients.TomatoSauce
                            },
                            Price = 18,
                            Diameter = 30
                        },
                        new Pizza
                        {
                            Id = 2,
                            Name = "basic 2",
                            Ingredients = new List<PizzaModels.Enums.Ingredients>
                            {
                                PizzaModels.Enums.Ingredients.Cheese,
                                PizzaModels.Enums.Ingredients.TomatoSauce
                            },
                            Price = 20,
                            Diameter = 30
                        }
                    }
                },
                new Pizzeria
                {
                    Id = 2,
                    Name = "Test pizzeria 2",
                    Coordinates = new GeoCoordinatePortable.GeoCoordinate(54.374589, 18.618032),
                    Pizzas = new List<Pizza>
                    {
                        new Pizza
                        {
                            Id = 3,
                            Name = "basic 3",
                            Ingredients = new List<PizzaModels.Enums.Ingredients>
                            {
                                PizzaModels.Enums.Ingredients.Cheese,
                                PizzaModels.Enums.Ingredients.Ham,
                                PizzaModels.Enums.Ingredients.TomatoSauce
                            },
                            Price = 15,
                            Diameter = 30
                        },
                        new Pizza
                        {
                            Id = 4,
                            Name = "basic 4",
                            Ingredients = new List<PizzaModels.Enums.Ingredients>
                            {
                                PizzaModels.Enums.Ingredients.Cheese,
                                PizzaModels.Enums.Ingredients.Onion,
                                PizzaModels.Enums.Ingredients.TomatoSauce
                            },
                            Price = 21,
                            Diameter = 30
                        }
                    }
                },
                new Pizzeria
                {
                    Id = 3,
                    Name = "Test pizzeria 3",
                    Coordinates = new GeoCoordinatePortable.GeoCoordinate(54.407452, 18.576299),
                    Pizzas = new List<Pizza>
                    {
                        new Pizza
                        {
                            Id = 5,
                            Name = "basic 5",
                            Ingredients = new List<PizzaModels.Enums.Ingredients>
                            {
                                PizzaModels.Enums.Ingredients.Cheese,
                                PizzaModels.Enums.Ingredients.Ham,
                                PizzaModels.Enums.Ingredients.TomatoSauce,
                                PizzaModels.Enums.Ingredients.Onion
                            },
                            Price = 30,
                            Diameter = 30
                        },
                        new Pizza
                        {
                            Id = 6,
                            Name = "basic 6",
                            Ingredients = new List<PizzaModels.Enums.Ingredients>
                            {
                                PizzaModels.Enums.Ingredients.TomatoSauce
                            },
                            Price = 10,
                            Diameter = 30
                        }
                    }
                }
            };
        }
    }
}
