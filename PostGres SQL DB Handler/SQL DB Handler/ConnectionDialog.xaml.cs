using System.Windows;
using System.Windows.Controls;

namespace SQL_DB_Handler
{
    /// <summary>
    /// Interaction logic for ConnectionDialog.xaml
    /// </summary>
    public partial class ConnectionDialog : UserControl
    {
        public ConnectionDialog()
        {
            InitializeComponent();
        }

        private void connectDB(object sender, System.Windows.RoutedEventArgs e)
        {
            if (((App)Application.Current).connObj == null)
                ((App)Application.Current).connObj = ConnectionHelper.GetSQLConnectionObject(new string[] { server.Text, port.Text, userId.Text, password.Text, database.Text });
        }
    }
}
