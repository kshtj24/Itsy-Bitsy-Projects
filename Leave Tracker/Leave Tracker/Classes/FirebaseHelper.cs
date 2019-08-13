using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Firebase.Database;
using Firebase.Database.Query;

namespace Leave_Tracker.Classes
{
    
   public class FirebaseHelper
    {
        FirebaseClient firebase = new FirebaseClient("https://leavetracker-b39bc.firebaseio.com/", new FirebaseOptions());
        public async Task<List<Leaves>> GetLeaves()
        {
            var response = (await firebase.Child("leaves").OnceAsync<Leaves>()).Select(item => new Leaves
            {
                OnDate = item.Object.OnDate,
                OnLeave = item.Object.OnLeave
            }).ToList();
                       
            return response;
        } 
    }
}
