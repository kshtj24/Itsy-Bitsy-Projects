using Prism.Commands;
using Prism.Mvvm;
using Prism.Navigation;
using System;
using System.Collections.Generic;
using System.Linq;

namespace QuotesApp.ViewModels
{
    public class WelcomePageViewModel : BindableBase
    {
        public DelegateCommand LoginCommand { get; set; }
        public INavigationService NavigationService { get; set; }

        public WelcomePageViewModel(INavigationService navigationService)
        {
            LoginCommand = new DelegateCommand(LoginMethod);
            NavigationService = navigationService;
        }

        private void LoginMethod()
        {
            NavigationService.NavigateAsync("HomePage");
        }
    }
}
