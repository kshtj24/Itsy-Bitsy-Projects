using LeaveTracker;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace Leave_Tracker
{
    // Learn more about making custom code visible in the Xamarin.Forms previewer
    // by visiting https://aka.ms/xamarinforms-previewer
    [DesignTimeVisible(false)]
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        protected async override void OnAppearing()
        {
            base.OnAppearing();

            MonthPicker.ItemsSource = Constants.Month_List;
            MonthPicker.SelectedIndex = DateTime.Now.Month - 1;

            YearPicker.ItemsSource = Constants.Year_List;
            YearPicker.SelectedItem = DateTime.Now.Year.ToString();

            RenderCalendar();
        }

        protected void UpdateCalendar(object sender, EventArgs e)
        {
            Calendar.Children.Clear();
            RenderCalendar();
        }

        private void RenderCalendar()
        {
            try
            {
                DateTime dateTime = new DateTime(int.Parse(YearPicker.SelectedItem.ToString()), Constants.Month_List.ToList().IndexOf(MonthPicker.SelectedItem.ToString()) + 1, 1);

                int column = ((int)dateTime.DayOfWeek);
                int totalDays = DateTime.DaysInMonth(int.Parse(YearPicker.SelectedItem.ToString()), Constants.Month_List.ToList().IndexOf(MonthPicker.SelectedItem.ToString()) + 1);
                int day = 1;

                for (int i = 1; i <= 5; i++)
                {
                    for (int j = column; j <= 6; j++)
                    {
                        if (day > totalDays)
                            return;

                        if (column != 0)
                            column = 0;

                        Button cell = new Button();
                        cell.Text = day.ToString();
                        cell.BackgroundColor = Color.White;

                        Grid.SetRow(cell, i);
                        Grid.SetColumn(cell, j);

                        Calendar.Children.Add(cell);
                        
                        day++;
                    }
                }
            }
            catch (Exception e)
            {

            }
        }
    }
}