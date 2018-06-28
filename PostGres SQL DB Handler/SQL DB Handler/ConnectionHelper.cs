using System;
using Npgsql;
using System.Data;
using System.Collections.Generic;

namespace SQL_DB_Handler
{
    static class ConnectionHelper
    {
        private static NpgsqlConnection connection = null;
        private static DataSet data = new DataSet();

        public static NpgsqlConnection GetSQLConnectionObject(string[] args)
        {
            if (connection == null)
            {
                string connectionString = string.Format("Server={0}; Port={1}; User Id = {2}; Password = {3}; Database = {4};", args[0], args[1], args[2], args[3], args[4]);
                connection = new NpgsqlConnection(connectionString);
            }

            return connection;
        }


        public static DataTable GetAllTables(string sql, NpgsqlConnection connection)
        {
            runQuery(sql, connection);
            return data.Tables[0];
        }

        public static bool DeleteTables(List<string> tableNames, NpgsqlConnection connection)
        {
            string sql = QueryStrings.DROP_TABLES;
            foreach (string table_name in tableNames)
            {                
                sql += table_name + ",";
            }

            sql = sql.TrimEnd(',');
            runQuery(sql, connection);
            return true;
        }

        static void runQuery(string sql, NpgsqlConnection connection)
        {
            NpgsqlDataAdapter adapter = new NpgsqlDataAdapter(sql += ";", connection);
            data.Reset();
            adapter.Fill(data);
        }
    }
}
