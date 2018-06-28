using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SQL_DB_Handler
{
    static class QueryStrings
    {
        public static string CREATE_TABLE = "CREATE TABLE ";
        public static string DROP_TABLES = "DROP TABLE ";
        public static string DISPLAY_ALL_TABLES = "SELECT * FROM pg_catalog.pg_tables";        
    }
}
