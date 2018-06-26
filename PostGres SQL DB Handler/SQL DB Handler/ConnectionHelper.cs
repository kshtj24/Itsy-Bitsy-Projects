using System;
using Npgsql;

namespace SQL_DB_Handler
{
    static class ConnectionHelper
    {
        private static NpgsqlConnection connection = null;

        public static NpgsqlConnection GetSQLConnectionObject(string[] args)
        {
            if (connection == null)
            {
                string connectionString = string.Format("Server={0}; Port={1}; User Id = {2}; Password = {3}; Database = {4};", args[0], args[1], args[2], args[3], args[4]);
                connection = new NpgsqlConnection(connectionString);
            }

            return connection;
        }
    }
}
