using System.Windows;

namespace SQL_DB_Handler
{
    /// Connection Dialog to connect to the specified Database
   
    public partial class ConnectionDialog : Window
    {
        public ConnectionDialog()
        {
            InitializeComponent();
        }

        private void connectDB(object sender, RoutedEventArgs e)
        {
            //if (((App)Application.Current).connObj == null)
            //    ((App)Application.Current).connObj = ConnectionHelper.GetSQLConnectionObject(new string[] { server.Text, port.Text, userId.Text, password.Text, database.Text });
            new MainWindow(ConnectionHelper.GetSQLConnectionObject(new string[] { server.Text, port.Text, userId.Text, password.Text, database.Text })).Show();
            Close();
        }
    }
}
