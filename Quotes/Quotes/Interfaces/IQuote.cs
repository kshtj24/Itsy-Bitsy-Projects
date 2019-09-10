using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace Quotes.Interfaces
{
    public interface IQuote
    {
        Task<List<Model.Quote>> GetQuotes();
    }
}
