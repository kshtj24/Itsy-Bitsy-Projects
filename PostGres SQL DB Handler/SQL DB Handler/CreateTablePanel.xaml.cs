using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace SQL_DB_Handler
{
    /// <summary>
    /// Interaction logic for CreateTablePanel.xaml
    /// </summary>
    public partial class CreateTablePanel : UserControl
    {
        public CreateTablePanel(int count)
        {
            InitializeComponent();
            populateAttributeList(count);
        }


        void populateAttributeList(int count)
        {
            for (int i = 0; i < count; i++)
            {
                TableAttributeListItem item = new TableAttributeListItem();
                item.Name = "Attribute" + i.ToString();
                attributesPanel.Children.Add(item);
            }

            Button button = new Button();
            button.Content = "Add Table";
            button.Click += new RoutedEventHandler(createTables);
            attributesPanel.Children.Add(button);
        }


        private void createTables(object sender, RoutedEventArgs e)
        {
            List<string> tableAttributesList = new List<string>();
            for (int i = 0; i < 10; i++)
            {
                //TableAttributeListItem item = attributesPanel.FindName("Attribute" + i.ToString());

                foreach (TableAttributeListItem item in attributesPanel.Children)
                {
                    if (item.attributeName.Text != "" || item.attributeName.Text != null)
                    {
                        string temp = (item.attributeName.Text).Replace(' ', '_') + item.dataType.SelectedItem;
                        tableAttributesList.Add(temp);
                    }
                }
            }
        }
    }
}
