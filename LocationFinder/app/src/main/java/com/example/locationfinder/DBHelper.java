package com.example.locationfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // Constants for database and table details
    private static final String DATABASE_NAME = "locations.db";
    private static final String TABLE_NAME = "locations";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    // Method to create table with columns
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ADDRESS + " TEXT NOT NULL UNIQUE, " +
                COLUMN_LATITUDE + " TEXT, " +
                COLUMN_LONGITUDE + " TEXT)";
        db.execSQL(createTable);

        // 100+ Pre-Inserted Locations
        String insertLocations = "INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES " +
                "('Oshawa Civic Centre', 43.8971, -78.8658)," +
                "('Ajax Community Centre', 43.8501, -79.0204)," +
                "('Pickering Town Centre', 43.8354, -79.0868)," +
                "('Scarborough Town Centre', 43.7735, -79.2577)," +
                "('Downtown Toronto - CN Tower', 43.6426, -79.3871)," +
                "('Mississauga City Centre', 43.5890, -79.6441)," +
                "('Brampton City Hall', 43.7315, -79.7624)," +
                "('Markham Civic Centre', 43.8561, -79.3370)," +
                "('Etobicoke Civic Centre', 43.6541, -79.5653)," +
                "('Vaughan Mills Mall', 43.8253, -79.5360)," +
                "('Richmond Hill Centre', 43.8708, -79.4377)," +
                "('Oakville Town Hall', 43.4675, -79.6877)," +
                "('Milton Sports Centre', 43.5183, -79.8796)," +
                "('Georgetown Market Place', 43.6506, -79.9322)," +
                "('Burlington City Hall', 43.3272, -79.7972)," +
                "('Whitby Civic Recreation Complex', 43.8844, -78.9403)," +
                "('Aurora Community Centre', 44.0065, -79.4504)," +
                "('Newmarket Riverwalk Commons', 44.0565, -79.4613)," +
                "('Bradford Community Centre', 44.1146, -79.5791)," +
                "('Uxbridge Arena & Recreation Centre', 44.1089, -79.1215)," +
                "('King City Community Centre', 43.9267, -79.5288)," +
                "('Nobleton Public Library', 43.9297, -79.6475)," +
                "('Stouffville Arena', 43.9716, -79.2465)," +
                "('Bolton Town Centre', 43.8748, -79.7357)," +
                "('Caledon Town Hall', 43.8668, -79.9948)," +
                "('Orangeville Town Hall', 43.9199, -80.0978)," +
                "('Schomberg Community Hall', 44.0076, -79.6842)," +
                "('Thornhill Community Centre', 43.8242, -79.4266)," +
                "('Richmond Green Sports Centre', 43.9034, -79.4057)," +
                "('Port Credit Memorial Park', 43.5534, -79.5873)," +
                "('Weston Lions Park', 43.7028, -79.5207)," +
                "('Eglinton Flats', 43.6792, -79.5060)," +
                "('High Park', 43.6465, -79.4637)," +
                "('Toronto Zoo', 43.8200, -79.1811)," +
                "('Downsview Park', 43.7366, -79.4878)," +
                "('Sunnybrook Park', 43.7274, -79.3623)," +
                "('Woodbine Beach', 43.6629, -79.3048)," +
                "('Rogers Centre', 43.6414, -79.3894)," +
                "('Casa Loma', 43.6780, -79.4094)," +
                "('Yorkdale Shopping Centre', 43.7254, -79.4525)," +
                "('Centennial Park Conservatory', 43.6433, -79.5848)," +
                "('Black Creek Pioneer Village', 43.7693, -79.5154)," +
                "('Guild Park and Gardens', 43.7407, -79.1966)," +
                "('Rouge National Urban Park', 43.8148, -79.1833)," +
                "('Bluffer''s Park', 43.7073, -79.2313)," +
                "('Evergreen Brick Works', 43.6847, -79.3657)," +
                "('Tommy Thompson Park', 43.6285, -79.3495)," +
                "('Sugar Beach', 43.6412, -79.3687)," +
                "('Woodbine Racetrack', 43.7167, -79.6010)," +
                "('Sherway Gardens', 43.6105, -79.5580)," +
                "('Pacific Mall', 43.8285, -79.3069)," +
                "('Promenade Mall', 43.8152, -79.4518)," +
                "('Hillcrest Mall', 43.8754, -79.4369)," +
                "('Square One Shopping Centre', 43.5931, -79.6410)," +
                "('Toronto Islands - Centre Island', 43.6205, -79.3786)," +
                "('Nathan Phillips Square', 43.6525, -79.3832)," +
                "('Royal Ontario Museum', 43.6677, -79.3948)," +
                "('Ripley''s Aquarium', 43.6424, -79.3860)," +
                "('Distillery District', 43.6503, -79.3596)," +
                "('St. Lawrence Market', 43.6490, -79.3716)," +
                "('The Danforth', 43.6780, -79.3530)," +
                "('Little Italy', 43.6542, -79.4206)," +
                "('Kensington Market', 43.6541, -79.4003)," +
                "('Harbourfront Centre', 43.6385, -79.3829)," +
                "('Yonge-Dundas Square', 43.6562, -79.3801)," +
                "('Art Gallery of Ontario', 43.6536, -79.3925)," +
                "('Toronto Eaton Centre', 43.6540, -79.3807)," +
                "('Nathan Phillips Square Ice Rink', 43.6527, -79.3834)," +
                "('University of Toronto - St. George Campus', 43.6629, -79.3957)," +
                "('Ryerson University', 43.6577, -79.3788)," +
                "('Ontario Science Centre', 43.7167, -79.3386)," +
                "('Toronto Botanical Garden', 43.7336, -79.3649)," +
                "('Aga Khan Museum', 43.7257, -79.3433)," +
                "('Toronto Public Library - Toronto Reference Library', 43.6710, -79.3867)," +
                "('Riverdale Farm', 43.6681, -79.3620)," +
                "('Elgin and Winter Garden Theatre Centre', 43.6547, -79.3784)," +
                "('Fort York National Historic Site', 43.6373, -79.4064)," +
                "('Spadina Museum', 43.6785, -79.4059)," +
                "('The Beaches', 43.6709, -79.2956)," +
                "('Scarborough Bluffs', 43.6956, -79.2345)," +
                "('The Don Valley Brick Works Park', 43.6863, -79.3651)," +
                "('Unionville Main Street', 43.8643, -79.3105)," +
                "('Richmond Hill David Dunlap Observatory', 43.8671, -79.4287)," +
                "('Toronto Harbour', 43.6383, -79.3807)," +
                "('Royal Alexandra Theatre', 43.6471, -79.3870)," +
                "('Bloor-Yorkville', 43.6696, -79.3871)," +
                "('Queen’s Park', 43.6540, -79.3800)," +
                "('Trinity Bellwoods Park', 43.6483, -79.4175)," +
                "('High Park Zoo', 43.6367, -79.4642)," +
                "('Mount Pleasant Cemetery', 43.7078, -79.3849)," +
                "('Toronto City Hall', 43.6536, -79.3817)," +
                "('St. Michael''s Cathedral Basilica', 43.6543, -79.3609)," +
                "('Allan Gardens Conservatory', 43.6643, -79.3711)," +
                "('David Pecaut Square', 43.6464, -79.3875)," +
                "('Eaton Chelsea Hotel', 43.6534, -79.3842)," +
                "('The Princess of Wales Theatre', 43.6496, -79.3878)," +
                "('Bayview Village Shopping Centre', 43.7615, -79.3852)," +
                "('Scarborough Civic Centre', 43.7731, -79.2597)," +
                "('St. Lawrence Hall', 43.6489, -79.3744)," +
                "('Kew Gardens', 43.6702, -79.2961)," +
                "('Ryerson Image Centre', 43.6549, -79.3793)," +
                "('Art Gallery of York University', 43.7712, -79.5093)," +
                "('Toronto Music Garden', 43.6333, -79.3702)," +
                "('Ontario Place', 43.6300, -79.4552)," +
                "('Sunnybrook Health Sciences Centre', 43.7461, -79.3803)," +
                "('Toronto General Hospital', 43.6614, -79.3855)," +
                "('Toronto Western Hospital', 43.6506, -79.4063)," +
                "('St. Joseph''s Health Centre', 43.6257, -79.4544)," +
                "('Loblaws at Maple Leaf Gardens', 43.6644, -79.3821)," +
                "('Greenwood Park', 43.6801, -79.3185)," +
                "('Blake Street Park', 43.6880, -79.3023)," +
                "('Dufferin Grove Park', 43.6843, -79.4275)," +
                "('Royal Conservatory of Music', 43.6648, -79.3997)," +
                "('SickKids Hospital', 43.6571, -79.3881)," +
                "('Gerrard Square Mall', 43.6698, -79.3282)," +
                "('Danforth Music Hall', 43.6785, -79.3487)," +
                "('Centre for Addiction and Mental Health', 43.6554, -79.4058)," +
                "('Kew Beach', 43.6706, -79.2950)," +
                "('Pape Village', 43.6835, -79.3269)," +
                "('Forest Hill Village', 43.7014, -79.4066)," +
                "('Cedarvale Park', 43.6849, -79.4372)," +
                "('York University', 43.7731, -79.5017)," +
                "('Liberty Village', 43.6345, -79.4175)," +
                "('The Four Seasons Centre for the Performing Arts', 43.6542, -79.3882)," +
                "('Moss Park', 43.6512, -79.3650)," +
                "('The Esplanade', 43.6486, -79.3644)," +
                "('Queen Street West', 43.6471, -79.4080)," +
                "('Bloor West Village', 43.6678, -79.4693)," +
                "('Yorkville Village', 43.6697, -79.3944)," +
                "('The Annex', 43.6715, -79.4077)," +
                "('Cabbagetown', 43.6639, -79.3632)," +
                "('Roncesvalles Avenue', 43.6509, -79.4592)," +
                "('Toronto Sculpture Garden', 43.6519, -79.3778)," +
                "('Nathan Phillips Square Garage', 43.6529, -79.3836)," +
                "('Toronto Reference Library', 43.6710, -79.3867)," +
                "('The Queensway', 43.6363, -79.5061)," +
                "('Chinatown Toronto', 43.6536, -79.4030)," +
                "('Little India', 43.6786, -79.3187)," +
                "('The Junction', 43.6728, -79.4705)," +
                "('Dundas Square', 43.6574, -79.3808)," +
                "('Toronto City Hall', 43.6536, -79.3817)," +
                "('Bloor-Danforth Subway Line', 43.6657, -79.4099)," +
                "('Don Mills Centre', 43.7530, -79.3437)," +
                "('Rosedale', 43.6692, -79.3745)," +
                "('Queen’s Street East', 43.6551, -79.3472)," +
                "('Spadina Avenue', 43.6539, -79.4001)," +
                "('St. Clair Avenue', 43.6892, -79.3990)," +
                "('Bloor Street West', 43.6667, -79.4212)," +
                "('Mount Dennis', 43.7004, -79.5132)," +
                "('Leaside', 43.7090, -79.3639)," +
                "('Gerrard Street East', 43.6686, -79.3149)," +
                "('Eglinton Avenue West', 43.7029, -79.4133)," +
                "('Harbord Village', 43.6640, -79.4101)," +
                "('King Street West', 43.6469, -79.4042)," +
                "('Broadview Avenue', 43.6708, -79.3595)," +
                "('Bay Street', 43.6557, -79.3806)," +
                "('Wellington Street', 43.6463, -79.3799);" ;

        db.execSQL(insertLocations);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to add and retrieve locations from the database
    public boolean addLocation(String address, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);
        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    // Method to retrieve a location from the database based on its address
    public Cursor getLocation(String address) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ADDRESS + " = ?", new String[]{address});
    }

    // Method to update the location in the database
    public boolean updateLocation(String address, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);
        int result = db.update(TABLE_NAME, values, COLUMN_ADDRESS + " = ?", new String[]{address});
        return result > 0;
    }

    // Method to delete a location from the database based on its address
    public boolean deleteLocation(String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, COLUMN_ADDRESS + " = ?", new String[]{address});
        return result > 0;
    }
}
