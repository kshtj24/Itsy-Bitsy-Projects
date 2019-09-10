using Quotes.Interfaces;
using Unity;
using Unity.ServiceLocation;
using Xamarin.Forms;
using Quotes.Services;
using CommonServiceLocator;

namespace Quotes
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();

            var unityContainer = new UnityContainer();
            unityContainer.RegisterType<IQuote, QuotesApi>();
            ServiceLocator.SetLocatorProvider(() => new UnityServiceLocator(unityContainer));

            MainPage = new View.MainPage();
        }

        protected override void OnStart()
        {
            // Handle when your app starts
        }

        protected override void OnSleep()
        {
            // Handle when your app sleeps
        }

        protected override void OnResume()
        {
            // Handle when your app resumes
        }
    }
}
