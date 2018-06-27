using System.Windows;
using Npgsql;
using System;

namespace SQL_DB_Handler
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        NpgsqlConnection connection = null;

        public MainWindow(NpgsqlConnection conn)
        {
            InitializeComponent();
            connection = conn;
        }

        private void create_Checked(object sender, RoutedEventArgs e)
        {
            try
            {
                int attCount = int.Parse(cnt.Text);
                playArea.Children.Add(new CreateTablePanel(attCount));
            }
            catch (Exception err)
            {
                MessageBox.Show("Please enter a numeric value.", err.Message);
            }
        }

        private void delete_Checked(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("SELECT * FROM pg_catalog.pg_tables;");
        }
    }
}
