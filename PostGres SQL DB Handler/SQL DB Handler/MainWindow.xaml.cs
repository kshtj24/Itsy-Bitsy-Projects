using System.Windows;
using Npgsql;
using System;
using System.Windows.Controls;
using System.Windows.Data;
using System.Data;
using System.Collections.Generic;

namespace SQL_DB_Handler
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        NpgsqlConnection connection = null;
        List<string> tables_tobe_deleted = new List<string>();
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
            //DataGrid dg = new DataGrid();
            //dg.SetBinding(ItemsControl.ItemsSourceProperty, new Binding { Source = ConnectionHelper.GetAllTables(QueryStrings.DISPLAY_ALL_TABLES, connection)});
            DataTable dataTable = ConnectionHelper.GetAllTables(QueryStrings.DISPLAY_ALL_TABLES, connection);
            ScrollViewer scrl = new ScrollViewer();
            StackPanel deleteTableStack = new StackPanel();

            scrl.Content = deleteTableStack;
            playArea.Children.Add(scrl);
            foreach (DataRow row in dataTable.Rows)
            {
                var values = row.ItemArray;
                if (values[0].ToString() == "public")
                {
                    DeleteTableListItem listItem = new DeleteTableListItem();
                    listItem.table_name.Content = values[1].ToString();
                    listItem.table_name.Checked += new RoutedEventHandler(tableSelected);
                    listItem.table_name.Unchecked += new RoutedEventHandler(tableDeselected);
                    deleteTableStack.Children.Add(listItem);
                }
            }

            Button button = new Button();
            button.Content = "Delete Selected";
            button.Click += new RoutedEventHandler(deletedSelectedTables);
            deleteTableStack.Children.Add(button);
        }

        private void tableSelected(object sender, RoutedEventArgs e)
        {
            tables_tobe_deleted.Add(((CheckBox)sender).Content.ToString());
        }

        private void tableDeselected(object sender, RoutedEventArgs e)
        {
            tables_tobe_deleted.Remove(((CheckBox)sender).Content.ToString());
        }

        private void deletedSelectedTables(object sender, RoutedEventArgs e)
        {
            if (ConnectionHelper.DeleteTables(tables_tobe_deleted, connection))
            {
                tables_tobe_deleted.Clear();
                MessageBox.Show("The selected tables have been deleted");
                playArea.Children.Clear();
                delete.IsChecked = false;
            }

        }
    }
}
