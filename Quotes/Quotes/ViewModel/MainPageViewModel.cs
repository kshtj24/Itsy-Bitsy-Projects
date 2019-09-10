using Newtonsoft.Json;
using Quotes.Interfaces;
using Quotes.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Net.Http;
using System.Text;

namespace Quotes.ViewModel
{
    public class MainPageViewModel : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        public ObservableCollection<Quote> Quotes { get; set; }

        private IQuote _quotes;

        public MainPageViewModel(IQuote quote)
        {
            Quotes = new ObservableCollection<Quote>();
            _quotes = quote;
            LoadQuotes();
        }

        private async void LoadQuotes()
        {
            var quotes = await _quotes.GetQuotes();
            foreach (var quote in quotes)
            {
                Quotes.Add(quote);
            }
        }
    }
}
