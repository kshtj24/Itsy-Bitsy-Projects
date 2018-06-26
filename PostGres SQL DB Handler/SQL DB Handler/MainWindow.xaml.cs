using System.Windows;

namespace SQL_DB_Handler
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            mainGrid.Children.Add(new ConnectionDialog());
        }
    }
}
