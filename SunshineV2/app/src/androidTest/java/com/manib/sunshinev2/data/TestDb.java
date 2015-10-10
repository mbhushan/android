package com.manib.sunshinev2.data;

/**
 * Created by manib on 08/10/15.
 */

import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.test.AndroidTestCase;

import com.manib.sunshinev2.utils.PollingCheck;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestDb extends AndroidTestCase {

    public static final String LOG_TAG = TestDb.class.getSimpleName();

    // Since we want each test to start with a clean slate
    void deleteTheDatabase() {
        mContext.deleteDatabase(WeatherDbHelper.DATABASE_NAME);
    }

    /*
        This function gets called before each test is executed to delete the database.  This makes
        sure that we always have a clean test.
     */
    public void setUp() {
        deleteTheDatabase();
    }

    /*
        Uncomment this test once you've written the code to create the Location
        table.  Note that you will have to have chosen the same column names that I did in
        my solution for this test to compile, so if you haven't yet done that, this is
        a good time to change your column names to match mine.
        Note that this only tests that the Location table has the correct columns, since we
        give you the code for the weather table.  This test does not look at the
     */
    public void testCreateDb() throws Throwable {
        // build a HashSet of all of the table names we wish to look for
        // Note that there will be another table in the DB that stores the
        // Android metadata (db version information)
        final HashSet<String> tableNameHashSet = new HashSet<String>();
        tableNameHashSet.add(WeatherContract.LocationEntry.TABLE_NAME);
        tableNameHashSet.add(WeatherContract.WeatherEntry.TABLE_NAME);

        mContext.deleteDatabase(WeatherDbHelper.DATABASE_NAME);
        SQLiteDatabase db = new WeatherDbHelper(
                this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());

        // have we created the tables we want?
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        assertTrue("Error: This means that the database has not been created correctly",
                c.moveToFirst());

        // verify that the tables have been created
        do {
            tableNameHashSet.remove(c.getString(0));
        } while( c.moveToNext() );

        // if this fails, it means that your database doesn't contain both the location entry
        // and weather entry tables
        assertTrue("Error: Your database was created without both the location entry and weather entry tables",
                tableNameHashSet.isEmpty());

        // now, do our tables contain the correct columns?
        c = db.rawQuery("PRAGMA table_info(" + WeatherContract.LocationEntry.TABLE_NAME + ")",
                null);

        assertTrue("Error: This means that we were unable to query the database for table information.",
                c.moveToFirst());

        // Build a HashSet of all of the column names we want to look for
        final HashSet<String> locationColumnHashSet = new HashSet<String>();
        locationColumnHashSet.add(WeatherContract.LocationEntry._ID);
        locationColumnHashSet.add(WeatherContract.LocationEntry.COLUMN_CITY_NAME);
        locationColumnHashSet.add(WeatherContract.LocationEntry.COLUMN_COORD_LAT);
        locationColumnHashSet.add(WeatherContract.LocationEntry.COLUMN_COORD_LONG);
        locationColumnHashSet.add(WeatherContract.LocationEntry.COLUMN_LOCATION_SETTING);

        int columnNameIndex = c.getColumnIndex("name");
        do {
            String columnName = c.getString(columnNameIndex);
            locationColumnHashSet.remove(columnName);
        } while(c.moveToNext());

        // if this fails, it means that your database doesn't contain all of the required location
        // entry columns
        assertTrue("Error: The database doesn't contain all of the required location entry columns",
                locationColumnHashSet.isEmpty());
        db.close();
    }

    /*
        Students:  Here is where you will build code to test that we can insert and query the
        location database.  We've done a lot of work for you.  You'll want to look in TestUtilities
        where you can uncomment out the "createNorthPoleLocationValues" function.  You can
        also make use of the ValidateCurrentRecord function from within TestUtilities.
    */
    public void testLocationTable() {
       // First step: Get reference to writable database
        // If there's an error in those massive SQL table creation Strings,
        // errors will be thrown here when you try to get a writable database.
        WeatherDbHelper dbHelper = new WeatherDbHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Second Step: Create ContentValues of what you want to insert
        // (you can use the createNorthPoleLocationValues if you wish)
        ContentValues testValues = TestUtilities.createNorthPoleLocationValues();

        // Third Step: Insert ContentValues into database and get a row ID back
        long locationRowId;
        locationRowId = db.insert(WeatherContract.LocationEntry.TABLE_NAME, null, testValues);

        // Verify we got a row back.
        assertTrue(locationRowId != -1);

        // Data's inserted.  IN THEORY.  Now pull some out to stare at it and verify it made
        // the round trip.

        // Fourth Step: Query the database and receive a Cursor back
        // A cursor is your primary interface to the query results.
        Cursor cursor = db.query(
                WeatherContract.LocationEntry.TABLE_NAME,  // Table to Query
                null, // all columns
                null, // Columns for the "where" clause
                null, // Values for the "where" clause
                null, // columns to group by
                null, // columns to filter by row groups
                null // sort order
        );

        // Move the cursor to a valid database row and check to see if we got any records back
        // from the query
        assertTrue( "Error: No Records returned from location query", cursor.moveToFirst() );

        // Fifth Step: Validate data in resulting Cursor with the original ContentValues
        // (you can use the validateCurrentRecord function in TestUtilities to validate the
        // query if you like)
        TestUtilities.validateCurrentRecord("Error: Location Query Validation Failed",
                cursor, testValues);

        // Move the cursor to demonstrate that there is only one record in the database
        assertFalse( "Error: More than one record returned from location query",
                cursor.moveToNext() );

        // Sixth Step: Close Cursor and Database
        cursor.close();
        db.close();

    }

    /*
        Students:  Here is where you will build code to test that we can insert and query the
        database.  We've done a lot of work for you.  You'll want to look in TestUtilities
        where you can use the "createWeatherValues" function.  You can
        also make use of the validateCurrentRecord function from within TestUtilities.
     */
    public void testWeatherTable() {
        // First insert the location, and then use the locationRowId to insert
        // the weather. Make sure to cover as many failure cases as you can.

        // Instead of rewriting all of the code we've already written in testLocationTable
        // we can move this code to insertLocation and then call insertLocation from both
        // tests. Why move it? We need the code to return the ID of the inserted location
        // and our testLocationTable can only return void because it's a test.

        // First step: Get reference to writable database

        // Create ContentValues of what you want to insert
        // (you can use the createWeatherValues TestUtilities function if you wish)

        // Insert ContentValues into database and get a row ID back

        // Query the database and receive a Cursor back

        // Move the cursor to a valid database row

        // Validate data in resulting Cursor with the original ContentValues
        // (you can use the validateCurrentRecord function in TestUtilities to validate the
        // query if you like)

        // Finally, close the cursor and database
    }


    /*
        Students: This is a helper method for the testWeatherTable quiz. You can move your
        code from testLocationTable to here so that you can call this code from both
        testWeatherTable and testLocationTable.
     */
    public long insertLocation() {
        return -1L;
    }

    /**
     * Created by manib on 08/10/15.
     */
    /*
        Students: These are functions and some test data to make it easier to test your database and
        Content Provider.  Note that you'll want your WeatherContract class to exactly match the one
        in our solution to use these as-given.
     */
    public static class TestUtilities extends AndroidTestCase {
        static final String TEST_LOCATION = "99705";
        static final long TEST_DATE = 1419033600L;  // December 20th, 2014

        static void validateCursor(String error, Cursor valueCursor, ContentValues expectedValues) {
            assertTrue("Empty cursor returned. " + error, valueCursor.moveToFirst());
            validateCurrentRecord(error, valueCursor, expectedValues);
            valueCursor.close();
        }

        static void validateCurrentRecord(String error, Cursor valueCursor, ContentValues expectedValues) {
            Set<Map.Entry<String, Object>> valueSet = expectedValues.valueSet();
            for (Map.Entry<String, Object> entry : valueSet) {
                String columnName = entry.getKey();
                int idx = valueCursor.getColumnIndex(columnName);
                assertFalse("Column '" + columnName + "' not found. " + error, idx == -1);
                String expectedValue = entry.getValue().toString();
                assertEquals("Value '" + entry.getValue().toString() +
                        "' did not match the expected value '" +
                        expectedValue + "'. " + error, expectedValue, valueCursor.getString(idx));
            }
        }

        /*
            Students: Use this to create some default weather values for your database tests.
         */
        static ContentValues createWeatherValues(long locationRowId) {
            ContentValues weatherValues = new ContentValues();
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_LOC_KEY, locationRowId);
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_DATE, TEST_DATE);
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_DEGREES, 1.1);
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_HUMIDITY, 1.2);
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_PRESSURE, 1.3);
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_MAX_TEMP, 75);
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_MIN_TEMP, 65);
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_SHORT_DESC, "Asteroids");
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_WIND_SPEED, 5.5);
            weatherValues.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_ID, 321);

            return weatherValues;
        }

        /*
            Students: You can uncomment this helper function once you have finished creating the
            LocationEntry part of the WeatherContract.
         */
        static ContentValues createNorthPoleLocationValues() {
            // Create a new map of values, where column names are the keys
            ContentValues testValues = new ContentValues();
            testValues.put(WeatherContract.LocationEntry.COLUMN_LOCATION_SETTING, TEST_LOCATION);
            testValues.put(WeatherContract.LocationEntry.COLUMN_CITY_NAME, "North Pole");
            testValues.put(WeatherContract.LocationEntry.COLUMN_COORD_LAT, 64.7488);
            testValues.put(WeatherContract.LocationEntry.COLUMN_COORD_LONG, -147.353);

            return testValues;
        }

        /*
            Students: You can uncomment this function once you have finished creating the
            LocationEntry part of the WeatherContract as well as the WeatherDbHelper.
         */
    //    static long insertNorthPoleLocationValues(Context context) {
    //        // insert our test records into the database
    //        WeatherDbHelper dbHelper = new WeatherDbHelper(context);
    //        SQLiteDatabase db = dbHelper.getWritableDatabase();
    //        ContentValues testValues = TestUtilities.createNorthPoleLocationValues();
    //
    //        long locationRowId;
    //        locationRowId = db.insert(WeatherContract.LocationEntry.TABLE_NAME, null, testValues);
    //
    //        // Verify we got a row back.
    //        assertTrue("Error: Failure to insert North Pole Location Values", locationRowId != -1);
    //
    //        return locationRowId;
    //    }

        /*
            Students: The functions we provide inside of TestProvider use this utility class to test
            the ContentObserver callbacks using the PollingCheck class that we grabbed from the Android
            CTS tests.
            Note that this only tests that the onChange function is called; it does not test that the
            correct Uri is returned.
         */
        static class TestContentObserver extends ContentObserver {
            final HandlerThread mHT;
            boolean mContentChanged;

            static TestContentObserver getTestContentObserver() {
                HandlerThread ht = new HandlerThread("ContentObserverThread");
                ht.start();
                return new TestContentObserver(ht);
            }

            private TestContentObserver(HandlerThread ht) {
                super(new Handler(ht.getLooper()));
                mHT = ht;
            }

            // On earlier versions of Android, this onChange method is called
            @Override
            public void onChange(boolean selfChange) {
                onChange(selfChange, null);
            }

            @Override
            public void onChange(boolean selfChange, Uri uri) {
                mContentChanged = true;
            }

            public void waitForNotificationOrFail() {
                // Note: The PollingCheck class is taken from the Android CTS (Compatibility Test Suite).
                // It's useful to look at the Android CTS source for ideas on how to test your Android
                // applications.  The reason that PollingCheck works is that, by default, the JUnit
                // testing framework is not running on the main Android application thread.
                new PollingCheck(5000) {
                    @Override
                    protected boolean check() {
                        return mContentChanged;
                    }
                }.run();
                mHT.quit();
            }
        }

        static TestContentObserver getTestContentObserver() {
            return TestContentObserver.getTestContentObserver();
        }
    }
}