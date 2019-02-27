using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MCSD
{
    class Person : IEquatable<Person>, ICloneable
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }

        public bool Equals(Person other)
        {
            return (FirstName == other.FirstName && LastName == other.LastName);
        }

        public object Clone(Person person)
        {
            Person other = new Person();
            other.FirstName = person.FirstName;
            other.LastName = person.LastName;

            return other;
        }
    }
}
