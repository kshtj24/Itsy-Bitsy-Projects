using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MCSD
{
    class Program
    {
        static void Main(string[] args)
        {
            Car[] cars = 
            {
                new Car { Name = "SSC ultimate aero", MaxMph = 257, HorsePower = 1183, Price = 654400m },
                new Car{ Name = "Bugati Veyron", MaxMph = 253, HorsePower = 1001, Price = 1700000m },
                new Car{ Name = "Maruti 800", MaxMph = 180, HorsePower = 300, Price =1000m },
                new Car{ Name = "Porshe Spyder", MaxMph =200 , HorsePower = 788, Price = 20809m},
                new Car{ Name = "Wagon", MaxMph = 50, HorsePower =2 , Price =100m }                
            };

            displayCars(cars);
            Console.ReadKey();
        }

        static void displayCars(Car[] cars)
        {
            Array.Sort(cars);

            foreach (Car car in cars)
                Console.WriteLine(string.Join(",", new string[] { car.Name, car.MaxMph.ToString(), car.HorsePower.ToString(), car.Price.ToString("c") }));
        }
    }
}
