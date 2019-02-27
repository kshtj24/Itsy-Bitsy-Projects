using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MCSD
{
    class Program
    {
        //IEquatable driver code
        static void Main(string[] args)
        {
            List<Person> persons = new List<Person>();

            //ICloneable interface driver


            //IEquatable interface driver
            //while(true)
            //{
            //    Person person = new Person();
            //    string[] temp = Console.ReadLine().Split(' ');

            //    if (temp[0] == "Quit")
            //        break;
            //    else
            //    {
            //        person.FirstName = temp[0];
            //        person.LastName = temp[1];

            //        if (!persons.Contains(person))
            //            persons.Add(person);
            //        else
            //            Console.WriteLine("Person exists");

            //    }
            //}            
        }
        //IComparer and IComparable driver code
        //static void Main(string[] args)
        //{
        //    Car[] cars = 
        //    {
        //        new Car { Name = "SSC ultimate aero", MaxMph = 257, HorsePower = 1183, Price = 654400m },
        //        new Car{ Name = "Bugati Veyron", MaxMph = 253, HorsePower = 1001, Price = 1700000m },
        //        new Car{ Name = "Maruti 800", MaxMph = 180, HorsePower = 300, Price =1000m },
        //        new Car{ Name = "Porshe Spyder", MaxMph =200 , HorsePower = 788, Price = 20809m},
        //        new Car{ Name = "Wagon", MaxMph = 50, HorsePower =2 , Price =100m },
        //        new Car{ Name = "Saleen S7 Twin Turbo", MaxMph = 248, HorsePower =750 , Price =555000m },          
        //        new Car{ Name = "Koenigsegg CCX", MaxMph = 245, HorsePower =806 , Price =545568m },               
        //        new Car{ Name = "Ferrari Enzo", MaxMph = 217, HorsePower =660 , Price =670000m },              
        //        new Car{ Name = "McLaren F1", MaxMph = 240, HorsePower =637 , Price =970000m }                
        //    };

            
        //    displayCarsComparable(cars);
        //    displayCarsComparer(cars);
        //    Console.ReadKey();
        //}

        static void displayCarsComparable(Car[] cars)
        {
            Array.Sort(cars);

            foreach (Car car in cars)                
                Console.WriteLine(String.Format("|{0,20}|{1,8}|{2,8}|{3,15}|", car.Name, car.MaxMph.ToString(), car.HorsePower.ToString(), car.Price.ToString("c")));
        }

        static void displayCarsComparer(Car[] cars)
        {
            while (true)
            {
                string compareby = Console.ReadLine();
                CarComparer comparer = new CarComparer();
                if (compareby == "N")
                    comparer.SortBy = CarComparer.CompareField.Name;
                else if (compareby == "MM")
                    comparer.SortBy = CarComparer.CompareField.MaxMph;
                else if (compareby == "HP")
                    comparer.SortBy = CarComparer.CompareField.HorsePower;
                else if (compareby == "P")
                    comparer.SortBy = CarComparer.CompareField.Price;
                else if (compareby == "Q")
                    return;

                Array.Sort(cars, comparer);

                foreach (Car car in cars)
                    Console.WriteLine(String.Format("|{0,20}|{1,8}|{2,8}|{3,15}|", car.Name, car.MaxMph.ToString(), car.HorsePower.ToString(), car.Price.ToString("c")));
            }
        }
    }
}
