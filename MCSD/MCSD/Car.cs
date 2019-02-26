using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MCSD
{
    class Car : IComparable<Car>
    {
        public string Name { get; set; }
        public int MaxMph { get; set; }
        public int HorsePower { get; set; }
        public decimal Price { get; set; }

        public int CompareTo(Car obj)
        {
            Car other = obj as Car;
            return Name.CompareTo(other.Name);         
        }
    }

    class CarComparer : IComparer<Car>
    {
        public enum CompareField { Name, MaxMph, HorsePower, Price }

        public CompareField SortBy = CompareField.Name;

        public int Compare(Car x, Car y) 
        {
            switch (SortBy) 
            {
                case CompareField.Name:
                    return x.Name.CompareTo(y.Name);
                    break;
                case CompareField.MaxMph:
                    return x.MaxMph.CompareTo(y.MaxMph);
                    break;
                case CompareField.HorsePower:
                    return x.HorsePower.CompareTo(y.HorsePower);
                    break;
                case CompareField.Price:
                    return x.Price.CompareTo(y.Price);
                    break;
            }
        }
    }

}
