using Newtonsoft.Json;
using Quotes.Interfaces;
using Quotes.Model;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Quotes.Services
{
    public class QuotesApi : IQuote
    {
        public async Task<List<Quote>> GetQuotes()
        {
            var httpClient = new HttpClient();
            var response = await httpClient.GetStringAsync("https://programming-quotes-api.herokuapp.com/quotes");
            var quotes = JsonConvert.DeserializeObject<List<Quote>>(response);

            return quotes;
        }
    }
}
