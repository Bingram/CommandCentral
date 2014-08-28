package com.android.jblm.commandcentral;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Brian & Joe 2014.
 *
 * Activty which displays a GoogleMap fragment with points copied from map on JBLM website
 *
 * Ideas after this was created include adding a search function or having a list of categories
 * Also making the markers have different categories is possible, just a matter of swapping the
 * points on screen.
 *
 * Should show the users location using a new GPS layer, see Developer site for assistance.
 */
public class MapsActivity extends FragmentActivity {

    private GoogleMap map; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        setUpMapIfNeeded();//run setup check

        /**
         * Possibly break out the different categories and assign them to buttons
         * contained in a view setup here which is brought up by a menu button
         * maybe a ListView in a  dialog fragment.
         */

    }

    /**
     * Currently lays out all the markers for the map
     * Could also setup the GPS layer for marking users current location relative to points
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (map == null) {
            map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (map != null) {


                // The Map is verified. It is now safe to manipulate the map.


                //Lat & Long for Madigan Hospital
                LatLng mHospital = new LatLng(47.108238,-122.551804);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Hospital")

                                //description of location
                        .snippet("Madigan Army Medical Center")

                                //LatLng made before is set as the position of the marker
                        .position(mHospital));


                //Lat & Long for Army Police
                LatLng police = new LatLng(47.091946,-122.611298);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Police")

                                //description of location
                        .snippet("Provost Marshal Office")

                                //LatLng made before is set as the position of the marker
                        .position(police));//then the


                //Lat & Long for Fort Lewis Cemetery
                LatLng cemetery = new LatLng(47.061825,-122.584511);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Cemetery")

                                //description of location
                        .snippet("Fort Lewis Cemetary")

                                //LatLng made before is set as the position of the marker
                        .position(cemetery));


                //Lat & Long for McChord Air Museum (Heritage Hill)
                LatLng airMuseum = new LatLng(47.131477,-122.482750);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Heritage Hill")

                                //description of location
                        .snippet("McChord Air Museum collection of vintage military aircraft " +
                                "is displayed at the Heritage Hill Air Park")

                                //LatLng made before is set as the position of the marker
                        .position(airMuseum));


                //Lat & Long for McChord Air Museum
                LatLng mcChordAirMuseum = new LatLng(47.061825,-122.584511);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Air Museum")

                                //description of location
                        .snippet("McChord Air Museum is the official USAF organization charged with " +
                                "preserving the history of the Air Force at McChord Airfield. The " +
                                "museum's collection includes aircraft, models, unit exhibits, armament, " +
                                "instruments, paintings, photographs, art, vintage uniforms and other " +
                                "memorabilia. The museum is also home to the McChord Air Museum Foundation," +
                                " a non-profit organization that supports the museum's activities.")

                                //LatLng made before is set as the position of the marker
                        .position(mcChordAirMuseum));


                //Lat & Long for Fort Lewis Army Museum
                LatLng armyMuseum = new LatLng(47.097141,-122.614998);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Army Museum")

                                //description of location
                        .snippet("Lewis Army Museum is located in the historic Red Shield Inn building, " +
                                "and is the only certified U.S. Army museum on the west coast. The " +
                                "Museum has the mission of preserving historic artifacts relevant to " +
                                "Camp Lewis, Fort Lewis, Army units at JBLM and the role of the United" +
                                " States Army in the exploration, defense and development of the Pacific" +
                                " Northwest. Museum holdings include educational exhibits, artwork, photographs," +
                                " artifacts, uniforms, Army vehicles, and a document reading room. The museum " +
                                "is also home to the Friends of the Fort Lewis Military Museum, a non-profit" +
                                " organization which supports the museum's programs.")

                                //LatLng made before is set as the position of the marker
                        .position(armyMuseum));


                //Lat & Long for Memorial Park
                LatLng memorialPark = new LatLng(47.061825,-122.584511);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Memorial Park")

                                //description of location
                        .snippet("Memorial Park is home to monuments commemorating fallen service " +
                                "members from many of the military units based at Joint Base Lewis-McChord.")

                                //LatLng you made before is set as the position of the marker
                        .position(memorialPark));



                //Lat & Long for Vehicle Park
                LatLng vehiclePark = new LatLng(47.097710,-122.615685);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Vehicle Park")

                                //description of location
                        .snippet("Vintage military vehicles and armament displayed, part of the " +
                                "Lewis Army Museum Collection.")

                                //LatLng you made before is set as the position of the marker
                        .position(vehiclePark));



                //Lat & Long for Cater Lake
                LatLng caterLake = new LatLng(47.132477,-122.524765);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Cater Lake")

                                //description of location
                        .snippet("Carter Lake. Closed recreational activities, except during special" +
                                " events. Access to the lake is managed by JBLM Communities office.")

                                //LatLng you made before is set as the position of the marker
                        .position(caterLake));


                //Lat & Long for The Commons
                LatLng commons = new LatLng(47.086891,-122.591270);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("The Commons")

                                //description of location
                        .snippet("The Commons outdoor recreation area features space for picnics, a" +
                                " skate plaza, playground, and splash park.")

                                //LatLng you made before is set as the position of the marker
                        .position(commons));


                //Lat & Long for Cowan Stadium
                LatLng cowanStadium = new LatLng(47.086136,-122.596092);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Cowan Stadium")

                                //description of location
                        .snippet("Cowan Stadium athletic complex includes a football field, electronic " +
                                "scoreboard, bleachers, and 1/4 mile track.")

                                //LatLng you made before is set as the position of the marker
                        .position(cowanStadium));


                //Lat & Long for Douhit Park (Eagles Pride Golf Course)
                LatLng douhitPark = new LatLng(47.084507,-122.669022);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Eagles Pride Golf Course")

                                //description of location
                        .snippet("Eagles Pride Golf Course is an 18-hole (winter) or 27-hole (summer), " +
                                "par 72 course with a slope rating of 122. The Caddy Shack Bar & Grill " +
                                "is located inside the clubhouse.")

                                //LatLng you made before is set as the position of the marker
                        .position(douhitPark));


                //Lat & Long for Holiday Park Family Camp
                LatLng holidayPark = new LatLng(47.120388,-122.469490);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Holiday Park Family Camp")

                                //description of location
                        .snippet("Holiday Park family camp, managed by Adventures Unlimited. Includes " +
                                "RV park, tent area, gazebo, playground and clubhouse. Office is open" +
                                " year-round.")

                                //LatLng you made before is set as the position of the marker
                        .position(holidayPark));



                //Lat & Long for Holiday Park Pavillion
                LatLng holidayParkPavillion = new LatLng(47.120804,-122.468460);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Holiday Park Pavillion")

                                //description of location
                        .snippet("Holiday Park pavilion function space. Includes seating, full kitchen." +
                                " Managed by Adventures Unlimited.")

                                //LatLng you made before is set as the position of the marker
                        .position(holidayParkPavillion));


                //Lat & Long for Cascade Village Dog Park
                LatLng cascadeDogPark = new LatLng(47.137100,-122.518471);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Cascade Village Dog Park")

                                //description of location
                        .snippet("Maintained by Lewis-McChord Communities.")

                                //LatLng you made before is set as the position of the marker
                        .position(cascadeDogPark));


                //Lat & Long for Lewis Dog Park
                LatLng lewisDogPark = new LatLng(47.090160,-122.630257);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Dog Park")

                                //description of location
                        .snippet("Maintained by The Pet Brigade.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisDogPark));


                //Lat & Long for McChord Dog Park
                LatLng mcChordDogPark = new LatLng(47.123535,-122.486343);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Dog Park")

                                //description of location
                        .snippet("Maintained by JBLM MWR.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordDogPark));


                //Lat & Long for McChord track
                LatLng mcChordTrack = new LatLng(47.137703,-122.495239);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Track")

                                //description of location
                        .snippet("1/4 mile track.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordTrack));


                //Lat & Long for Memorial Stadium
                LatLng memorialStadium = new LatLng(47.086285,-122.598000);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Memorial Stadium")

                                //description of location
                        .snippet("Memorial Stadium is a park-like space with stadium-style bleachers," +
                                " suitable for outdoor concerts and events. It can also be reserved " +
                                "for unit functions.")

                                //LatLng you made before is set as the position of the marker
                        .position(memorialStadium));


                //Lat & Long for Memorial Field
                LatLng memorialField = new LatLng(47.134228,-122.494705);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Memorial Field")

                                //description of location
                        .snippet("Memorial Field Park.")

                                //LatLng you made before is set as the position of the marker
                        .position(memorialField));



                //Lat & Long for NAC Travel Camp
                LatLng travelCamp = new LatLng(47.108459,-122.585655);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("NAC Travel Camp")

                                //description of location
                        .snippet("The NAC Travel Camp, includes RV park, tent area, cabins, common " +
                                "areas with amenities (TV, washing machines, etc.) and access to American Lake.")

                                //LatLng you made before is set as the position of the marker
                        .position(travelCamp));


                //Lat & Long for Playground at The Commons
                LatLng playgroundCommons = new LatLng(47.086796,-122.591805);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Playground at The Commons")

                                //description of location
                        .snippet("The Playground at The Commons is handicapped-accessible, and open year-round.")

                                //LatLng you made before is set as the position of the marker
                        .position(playgroundCommons));


                //Lat & Long for Rainier Field
                LatLng rainierField = new LatLng(47.132458,-122.495667);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Rainier Field")

                                //description of location
                        .snippet("Rainier Field/Soccer Field.")

                                //LatLng you made before is set as the position of the marker
                        .position(rainierField));


                //Lat & Long for Shoreline Field
                LatLng  shorelineField = new LatLng(47.113960,-122.579857);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Shoreline Field")

                                //description of location
                        .snippet("Pavilion rentals, bathroom/shower facilities. Swimming allowed when " +
                                "lifeguards are on duty. Paddle boats, kayaks available for rent at " +
                                "Russell Landing marina.")

                                //LatLng you made before is set as the position of the marker
                        .position(shorelineField));



                //Lat & Long for Skate Plaza
                LatLng  skatePlaza = new LatLng(47.087238,-122.590897);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Skate Plaza")

                                //description of location
                        .snippet("Open to skateboarding and bicycles year-round.")

                                //LatLng you made before is set as the position of the marker
                        .position(skatePlaza));




                //Lat & Long for Solo Point
                LatLng soloPoint = new LatLng(47.138542,-122.632133);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Solo Point")

                                //description of location
                        .snippet("Running and hiking trails, family beach, and boat launch are open " +
                                "during daylight hours. No swimming. Open to military ID cardholders. " +
                                "Each cardholder may sponsor two non-military guests. Visitors who " +
                                "are not sponsored and not military ID cardholders must have a Visitors " +
                                "Pass or Area Access Pass, and are not authorized use of the boat launch. " +
                                "For vehicle parking, a DoD vehicle decal or a Visitor's Pass/Area Access " +
                                "Pass issued to the registered owner is required.")

                                //LatLng you made before is set as the position of the marker
                        .position(soloPoint));



                //Lat & Long for Summer Cove
                LatLng summerCove = new LatLng(47.125866,-122.579674);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Summer Cove")

                                //description of location
                        .snippet("Picturesque waterfront park on American Lake with shallow wading " +
                                "area, a sandy beach camp; a huge playground. Stroll the trails, " +
                                "bring a picnic and enjoy the wildlife with a view!")

                                //LatLng you made before is set as the position of the marker
                        .position(summerCove));



                //Lat & Long for Splash Park
                LatLng splashPark = new LatLng(47.087067,-122.591675);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Splash Park")

                                //description of location
                        .snippet("The Splash Park is located at The Commons, and operates Memorial " +
                                "Day through Labor Day.")

                                //LatLng you made before is set as the position of the marker
                        .position(splashPark));



                //Lat & Long for Watkins Field
                LatLng watkinsField = new LatLng(47.089382,-122.610168);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Watkins Field")

                                //description of location
                        .snippet("Watkins Field is located in the heart of the JBLM Lewis Main historic " +
                                "district. Many large unit ceremonies are hosted here to take advantage " +
                                "of the unobstructed view of Mount Rainier visible beyond the parade field.")

                                //LatLng you made before is set as the position of the marker
                        .position(watkinsField));



                //Lat & Long for Whispering Firs Golf Course
                LatLng whisperingFirs = new LatLng(47.124283,-122.508301);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Whispering Firs Golf Course")

                                //description of location
                        .snippet("Whispering Firs Golf Course is an 18-hole, par 72 course with a " +
                                "slope rating of 122. The Habanero Mexican Grill is located inside " +
                                "the clubhouse.")

                                //LatLng you made before is set as the position of the marker
                        .position(whisperingFirs));



                //Lat & Long for Eagles Pride Golf Course
                LatLng eaglesPride = new LatLng(47.087189,-122.664070);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Eagles Pride Golf Course")

                                //description of location
                        .snippet(".")

                                //LatLng you made before is set as the position of the marker
                        .position(eaglesPride));



                //Lat & Long for Holiday Park Campground
                LatLng campground = new LatLng(47.120533,-122.468872);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Holiday Park Campground")

                                //description of location
                        .snippet("Holiday Park family camp pavilion.")

                                //LatLng you made before is set as the position of the marker
                        .position(campground));



                //Lat & Long for Northwest Adventure Center Campground
                LatLng nACTravelCamp = new LatLng(47.108795,-122.585617);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("NAC Travel Camp")

                                //description of location
                        .snippet("")

                                //LatLng you made before is set as the position of the marker
                        .position(nACTravelCamp));



                //Lat & Long for Solo Point Fishing
                LatLng soloPtFishing = new LatLng(47.139408,-122.636436);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Solo Point Fishing")

                                //description of location
                        .snippet("Fishing is open to military ID cardholders. In addition cardholder " +
                                "may sponsor two non-military guests to fish without obtaining " +
                                "additional permits. Visitors who are not sponsored and not military " +
                                "ID cardholders must have an Area Access  Pass to fish.")

                                //LatLng you made before is set as the position of the marker
                        .position(soloPtFishing));



                //Lat & Long for American Lake Fishing
                LatLng aLFishing = new LatLng(47.121700,-122.578934);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("American Lake Fishing")

                                //description of location
                        .snippet("Fishing is open to military ID cardholders. In addition cardholder " +
                                "may sponsor two non-military guests to fish without obtaining " +
                                "additional permits. Visitors who are not sponsored and not military " +
                                "ID cardholders must have an Area Access Pass to fish. Additionally, " +
                                "a Visitors Pass may be required to access this location.")

                                //LatLng you made before is set as the position of the marker
                        .position(aLFishing));



                //Lat & Long for Russell Landing Marina
                LatLng rLMarina = new LatLng(47.121937,-122.580032);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Russell Landing Marina")

                                //description of location
                        .snippet(".")

                                //LatLng you made before is set as the position of the marker
                        .position(rLMarina));



                //Lat & Long for Boating at Solo Point
                LatLng sPtBoating = new LatLng(47.139469,-122.631516);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Solo Point Boating")

                                //description of location
                        .snippet("Boat ramp at Solo Point.  Open to military ID cardholders and their guests.")

                                //LatLng you made before is set as the position of the marker
                        .position(sPtBoating));



                //Lat & Long for indoor swimming pool
                LatLng kimbroPool = new LatLng(47.087734,-122.598747);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Kimbro Indoor Pool")

                                //description of location
                        .snippet("Inside McVeigh's Gym.")

                                //LatLng you made before is set as the position of the marker
                        .position(kimbroPool));



                //Lat & Long for Outdoor Pool on McChord
                LatLng mcChordOutPool = new LatLng(47.134418,-122.490593);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord's Outdoor Pool")

                                //description of location
                        .snippet("McChord's Outdoor Pool.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordOutPool));



                //Lat & Long for Shoreline Park Swimming
                LatLng shorelineParkSwim = new LatLng(47.132458,-122.495667);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Shoreline Park Swimming")

                                //description of location
                        .snippet("Swimming allowed seasonally (Memorial Day - Labor Day), when " +
                                "lifeguards are on duty.")

                                //LatLng you made before is set as the position of the marker
                        .position(shorelineParkSwim));



                //Lat & Long for Soldier's Field House Pool
                LatLng soldierPool = new LatLng(47.082642,-122.572998);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Soldier Field House Pool")

                                //description of location
                        .snippet("Indoor pool in Soldier's Field House Gym.")

                                //LatLng you made before is set as the position of the marker
                        .position(soldierPool));



                //Lat & Long for JBLM Wellness Center
                LatLng wellnessCenter = new LatLng(47.089310,-122.604874);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("JBLM Wellness Center")

                                //description of location
                        .snippet("JBLM Wellness Center provides health &amp; wellness services to " +
                                "members of the JBLM community.")

                                //LatLng you made before is set as the position of the marker
                        .position(wellnessCenter));




                //Lat & Long for Jensen Family Health & Fitness Center
                LatLng jensenGym = new LatLng(47.132458,-122.495667);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Jensen Family Health & Fitness Center")

                                //description of location
                        .snippet("Offers access to weightlifting and cardiovascular workout equipment," +
                                " fitness classes, and hourly child care. Jensen is also home to the " +
                                "JBLM Wellness Center, which provides health and wellness services to " +
                                "JBLM service members and their families.")

                                //LatLng you made before is set as the position of the marker
                        .position(jensenGym));



                //Lat & Long for Madigan Army Medical Center
                LatLng mAMC = new LatLng(47.108593,-122.551460);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Madigan Army Medical Center")

                                //description of location
                        .snippet("Madigan Army Medical Center is one of the largest military medical " +
                                "centers on the west coast, and a primary provider of emergency, " +
                                "specialty, pharmacy services and family health care to Joint Base " +
                                "Lewis-McChord service members and families. The hospital also provides " +
                                "services to eligible military retirees and their dependent family members. " +
                                "The hospital also oversees Madigan Medical Home clinics, which bring " +
                                "convenient military family health care into neighboring communities.")

                                //LatLng you made before is set as the position of the marker
                        .position(mAMC));



                //Lat & Long for Sheridan Sports & Fitness Center
                LatLng sheridanGym = new LatLng(47.076733,-122.587303);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Sheridan Sports & Fitness Center")

                                //description of location
                        .snippet("Sheridan Sports & Fitness Center offers access to cardiovascular " +
                                "and strength training equipment; basketball and volleyball courts; " +
                                "functional fitness area, and fitness classes.")

                                //LatLng you made before is set as the position of the marker
                        .position(sheridanGym));



                //Lat & Long for Soldier's Field House Fitness Center
                LatLng soldiersFitnessCenter = new LatLng(47.082657,-122.572243);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Soldier's Field House Fitness Center")

                                //description of location
                        .snippet("Offers access to weightlifting and cardiovascular workout equipment, " +
                                "fitness classes, functional fitness area, basketball and volleyball " +
                                "courts, outdoor tennis. Soldiers Field House Pool is located inside")

                                //LatLng you made before is set as the position of the marker
                        .position(soldiersFitnessCenter));



                //Lat & Long for McChord Fitness Center
                LatLng mcChordFitnessCenter = new LatLng(47.134518,-122.491005);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Fitness Center")

                                //description of location
                        .snippet("Equipped with basketball, volleyball and racquetball courts, " +
                                "cardiovascular and strength training equipment.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordFitnessCenter));



                //Lat & Long for McChord Fitness Center Annex
                LatLng mcChordAnnex = new LatLng(47.132458,-122.495667);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Fitness Center Annex")

                                //description of location
                        .snippet("Provides an indoor running track, access to cardio equipment, and" +
                                " fitness classes. The Annex also has family fitness rooms equipped " +
                                "for \"life of sight\" supervision of children (ages 6 months to 7 " +
                                "years) during their workout.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordAnnex));



                //Lat & Long for McChord Health & Wellness Center (HAWC)
                LatLng hAWC = new LatLng(47.132458,-122.495667);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Health & Wellness Center (HAWC)")

                                //description of location
                        .snippet("HAWC, is operated by 62nd Medical Squadron.")

                                //LatLng you made before is set as the position of the marker
                        .position(hAWC));



                //Lat & Long for McChord Medical Clinic
                LatLng mcChordMedicalClinic = new LatLng(47.130245,-122.495590);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Medical Clinic")

                                //description of location
                        .snippet("McChord Medical Clinic, operated by 62nd Medical Squadron.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordMedicalClinic));



                //Lat & Long for McChord Pool
                LatLng mcChordPool = new LatLng(47.134563,-122.490685);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord's Outdoor Pool")

                                //description of location
                        .snippet("Seasonal Outdoor Pool")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordPool));



                //Lat & Long for McVeigh Sports and Fitness Center
                LatLng mcVeighGym = new LatLng(47.087700,-122.599266);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McVeigh Sports and Fitness Center")

                                //description of location
                        .snippet("Offers racquetball courts, cardiovascular and strength training " +
                                "equipment, outdoor tennis, rock climbing wall, functional fitness " +
                                "area, fitness classes. Kimbro Pool is located inside.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcVeighGym));



                //Lat & Long for Wilson Sports & Fitness Center
                LatLng wilsonGym = new LatLng(47.127419,-122.604340);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Wilson Sports & Fitness Center")

                                //description of location
                        .snippet("Wilson Sports & Fitness Center services include weightlifting and" +
                                " cardiovascular workout equipment, fitness classes, personal training.")

                                //LatLng you made before is set as the position of the marker
                        .position(wilsonGym));



                //Lat & Long for Central Issue Facility (CIF)
                LatLng cIF = new LatLng(47.112911,-122.538948);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Central Issue Facility (CIF)")

                                //description of location
                        .snippet("")

                                //LatLng you made before is set as the position of the marker
                        .position(cIF));



                //Lat & Long for Conditioning Course
                LatLng conditioningCourse = new LatLng(47.132458,-122.495667);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Conditioning Course")

                                //description of location
                        .snippet("Conditioning Course. For military training, only.")

                                //LatLng you made before is set as the position of the marker
                        .position(conditioningCourse));



                //Lat & Long for Confidence Course
                LatLng confidenceCourse = new LatLng(47.121262,-122.598579);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Confidence Course")

                                //description of location
                        .snippet("Confidence Course. For military training, only.")

                                //LatLng you made before is set as the position of the marker
                        .position(confidenceCourse));



                //Lat & Long for Enterprise Multimedia Center
                LatLng enterpriseMultimediaCenter = new LatLng(47.090908,-122.627182);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Enterprise Multimedia Center")

                                //description of location
                        .snippet("Official photos, graphics and signage, audio-visual services.")

                                //LatLng you made before is set as the position of the marker
                        .position(enterpriseMultimediaCenter));



                //Lat & Long for JBLM Passenger Terminal
                LatLng passengerTerminal = new LatLng(47.150436,-122.484283);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("JBLM Passenger Terminal")

                                //description of location
                        .snippet("JBLM passengerTerminal.")

                                //LatLng you made before is set as the position of the marker
                        .position(passengerTerminal));



                //Lat & Long for Range Operations Office
                LatLng rangeOffice = new LatLng(47.089703,-122.621307);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Range Operations Office")

                                //description of location
                        .snippet("Schedules activity on JBLM training areas and firing ranges. " +
                                "Manages area access pass program for recreational use of JBLM " +
                                "wilderness training areas.")

                                //LatLng you made before is set as the position of the marker
                        .position(rangeOffice));



                //Lat & Long for AbilityOne Base Supply Center1
                LatLng abilityOne1 = new LatLng(47.126789,-122.498322);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("AbilityOne Base Supply Center 1")

                                //description of location
                        .snippet(" Base Supply Center operates retail office supply stores for GSA customers.")

                                //LatLng you made before is set as the position of the marker
                        .position(abilityOne1));



                //Lat & Long for AbilityOne Base Supply Center2
                LatLng abilityOne2 = new LatLng(47.119125,-122.606033);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("AbilityOne Base Supply Center 2")

                                //description of location
                        .snippet(" Base Supply Center operates retail office supply stores for GSA customers.")

                                //LatLng you made before is set as the position of the marker
                        .position(abilityOne2));



                //Lat & Long for Shopping Center
                LatLng shoppingCenter = new LatLng(47.124992,-122.495956);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Main Shopping Center")

                                //description of location
                        .snippet("")

                                //LatLng you made before is set as the position of the marker
                        .position(shoppingCenter));



                //Lat & Long for Lewis Main Commissary
                LatLng lewisCommissary = new LatLng(47.090668,-122.593292);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Main Commissary")

                                //description of location
                        .snippet("The Lewis Main Commissary is operated by the Defense Commissary Agency.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisCommissary));



                //Lat & Long for McChord Field Commissary
                LatLng mcChordCommissary = new LatLng(47.124825,-122.498093);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Field Commissary")

                                //description of location
                        .snippet("The McChord Field Commissary is operated by the Defense Commissary Agency (DECA).")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordCommissary));



                //Lat & Long for Lewis Main Exchange
                LatLng lewisMainExchange = new LatLng(47.092041,-122.589615);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Main Exchange")

                                //description of location
                        .snippet("The Lewis Main & McChord Field Exchange stores are operated by the" +
                                " Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisMainExchange));



                //Lat & Long for McChord Field Exchange
                LatLng mcChordFieldExchange = new LatLng(47.127132,-122.496063);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Field Exchange")

                                //description of location
                        .snippet("The Lewis Main & McChord Field Exchange stores are operated by the " +
                                "Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordFieldExchange));



                //Lat & Long for Mini Mall
                LatLng miniMall = new LatLng(47.089069,-122.593140);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Mini Mall")

                                //description of location
                        .snippet("The Military Clothing Sales store and food court are operated by " +
                                "the Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(miniMall));



                //Lat & Long for 3rd Brigade Express
                LatLng thirdExpress = new LatLng(47.076622,-122.591415);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("3rd Brigade Express")

                                //description of location
                        .snippet("3rd Brigade Express shoppette and restaurants are operated by the " +
                                "Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(thirdExpress));



                //Lat & Long for Lewis North Express
                LatLng lewisNorthExpress = new LatLng(47.125111,-122.600616);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis North Express")

                                //description of location
                        .snippet("Lewis North Express shoppette, service station, and restaurants are operated by the Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisNorthExpress));



                //Lat & Long for Liberty Express
                LatLng libertyExpress = new LatLng(47.097771,-122.585602);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Liberty Express")

                                //description of location
                        .snippet("Liberty Express shoppette, service station, and restaurants are " +
                                "operated by the Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(libertyExpress));



                //Lat & Long for Madigan Express
                LatLng madiganExpress = new LatLng(47.114460,-122.550735);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Madigan Express")

                                //description of location
                        .snippet("Madigan Express shoppette, service station and restaurants are " +
                                "operated by the Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(madiganExpress));



                //Lat & Long for McChord Express
                LatLng mcChordExpress = new LatLng(47.123291,-122.495415);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Express")

                                //description of location
                        .snippet("McChord Express shoppette, service station and restaurants are " +
                                "operated by the Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordExpress));



                //Lat & Long for Pendleton Express
                LatLng pendletonExpress = new LatLng(47.090752,-122.572426);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Pendleton Express")

                                //description of location
                        .snippet("Pendleton Express shoppette, service station, and restaurants are " +
                                "operated by the Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(pendletonExpress));



                //Lat & Long for Stryker Express
                LatLng strykerExpress = new LatLng(47.084549,-122.606148);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Stryker Express")

                                //description of location
                        .snippet("Stryker Express shoppette and service station is operated by the " +
                                "Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(strykerExpress));



                //Lat & Long for ACS Annex
                LatLng aCSAnnex = new LatLng(47.087681,-122.595222);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("ACS Annex")

                                //description of location
                        .snippet("Army Community Service (ACS) Annex is home to Financial Readiness, " +
                                "Army Emergency Relief, and Survivor Outreach Services.")

                                //LatLng you made before is set as the position of the marker
                        .position(aCSAnnex));



                //Lat & Long for Airmen & Family Readiness Center
                LatLng airmenReadiness = new LatLng(47.123974,-122.491898);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Airmen & Family Readiness Center")

                                //description of location
                        .snippet("The Airmen & Family Readiness Center is a one-stop shop for " +
                                "relocation readiness and critical family services at McChord Field " +
                                "- including ACS community services, Air Force Aid Society, the Exceptional " +
                                "Family Member Program (EFMP), and the Key Spouse program.")

                                //LatLng you made before is set as the position of the marker
                        .position(airmenReadiness));



                //Lat & Long for Better Opportunitites for Single Servicemembers
                LatLng bOSS = new LatLng(47.128338,-122.603165);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Better Opportunitites for Single Servicemembers")

                                //description of location
                        .snippet("Located in Warrior Zone.")

                                //LatLng you made before is set as the position of the marker
                        .position(bOSS));



                //Lat & Long for Book Patch Children's Library
                LatLng bookPatchLibrary = new LatLng(47.089420,-122.599144);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Book Patch Children's Library")

                                //description of location
                        .snippet("Book Patch Children's Library is located inside Grandstaff Library, " +
                                "and is operated by JBLM Libraries. Services include books, DVDs, " +
                                "internet access, wi-fi, wireless printing, and family story time.")

                                //LatLng you made before is set as the position of the marker
                        .position(bookPatchLibrary));



                //Lat & Long for Carey Theater
                LatLng careyTheater = new LatLng(47.087589,-122.597694);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Carey Theater")

                                //description of location
                        .snippet("Carey Theater can be configured for training activities, concerts, " +
                                "It is also the home of Reel Time Theater at JBLM, operated by the " +
                                "Army and Air Force Exchange Service.")

                                //LatLng you made before is set as the position of the marker
                        .position(careyTheater));



                //Lat & Long for Chapel #5
                LatLng chapel5 = new LatLng(47.087791,-122.594116);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Chapel #5")

                                //description of location
                        .snippet("Managed by the JBLM Chaplains Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(chapel5));



                //Lat & Long for Escape Zone
                LatLng escapeZone = new LatLng(47.120251,-122.502480);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Escape Zone")

                                //description of location
                        .snippet("Escape Zone Parent & Child Activity Center provides free, interactive " +
                                "learning and play opportunities for children ages 5 and under, and " +
                                "their parents.")

                                //LatLng you made before is set as the position of the marker
                        .position(escapeZone));



                //Lat & Long for Evergreen Chapel
                LatLng evergreenChapel = new LatLng(47.081692,-122.570839);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Evergreen Chapel")

                                //description of location
                        .snippet("Evergreen Chapel, managed by the JBLM Chaplains Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(evergreenChapel));



                //Lat & Long for Family Resource Center
                LatLng familyResourceCenter = new LatLng(47.098007,-122.609940);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Family Resource Center")

                                //description of location
                        .snippet("Family Resource Center provides meeting and event space for Family " +
                                "Readiness Groups. Also at this location: Installation Volunteer " +
                                "Coordinator, Private Organization Office, Army Family Team Building " +
                                "(AFTB), Armed Forces Action Plan (AFAP).")

                                //LatLng you made before is set as the position of the marker
                        .position(familyResourceCenter));



                //Lat & Long for Fisher House
                LatLng fisherHouse = new LatLng(47.101585,-122.543488);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Fisher House")

                                //description of location
                        .snippet("Fisher House - JBLM is a non-profit organization offering lodging " +
                                "assistance to families of patients undergoing long-term treatment " +
                                "at Madigan Army Medical Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(fisherHouse));



                //Lat & Long for Four Chaplains Memorial Chapel
                LatLng fourChaplainsChapel = new LatLng(47.102036,-122.555550);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Four Chaplains Memorial Chapel")

                                //description of location
                        .snippet("Four Chaplains Memorial Chapel, managed by the JBLM Chaplains " +
                                "Office. The JBLM Family Life Center is located inside.")

                                //LatLng you made before is set as the position of the marker
                        .position(fourChaplainsChapel));



                //Lat & Long for French Theater
                LatLng frenchTheater = new LatLng(47.092373,-122.611954);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("French Theater")

                                //description of location
                        .snippet("French Theater is available for training activities.")

                                //LatLng you made before is set as the position of the marker
                        .position(frenchTheater));



                //Lat & Long for Grandstaff Library
                LatLng grandstaffLibrary = new LatLng(47.089424,-122.599503);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Grandstaff Library")

                                //description of location
                        .snippet("Grandstaff Library is operated by JBLM Libraries. Services include " +
                                "computer and internet access/wi-fi, wireless printing, copier/scanner " +
                                "equipment, books, e-books, magazines, music, DVDs and more.")

                                //LatLng you made before is set as the position of the marker
                        .position(grandstaffLibrary));



                //Lat & Long for Hawk Education Center
                LatLng hawkEducationCenter = new LatLng(47.126568,-122.603096);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Hawk Education Center")

                                //description of location
                        .snippet("John D. \"Bud\" Hawk Education Center provides space for college" +
                                "classes, military training, and a computer lab on Lewis North.")

                                //LatLng you made before is set as the position of the marker
                        .position(hawkEducationCenter));



                //Lat & Long for Housing Services Office - Lewis Main
                LatLng lewisHousingOffice = new LatLng(47.090237,-122.595116);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Housing Services Office - Lewis Main")

                                //description of location
                        .snippet("Housing Services Office assists Service Members and Families with " +
                                "relocation and off-base housing. Managed by JBLM DPW.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisHousingOffice));



                //Lat & Long for Housing Services Office - McChord Field
                LatLng mcChordHousing = new LatLng(47.127636,-122.524040);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Housing Services Office - McChord Field")

                                //description of location
                        .snippet("Housing Services Office assists Service Members and Families with " +
                                "relocation and off-base housing. Managed by JBLM DPW.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordHousing));



                //Lat & Long for JBLM Family Life Center
                LatLng jBLMFamilyLifeCenter = new LatLng(47.101898,-122.555367);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("JBLM Family Life Center")

                                //description of location
                        .snippet("JBLM Family Life Center offers pastoral counseling (relationship, " +
                                "marriage, family, and individual counseling). Located inside Four " +
                                "Chaplains Memorial Chapel. Managed by the JBLM Chaplains Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(jBLMFamilyLifeCenter));



                //Lat & Long for Lewis Main Post Office
                LatLng lewisPO = new LatLng(47.092117,-122.617004);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Main Post Office")

                                //description of location
                        .snippet("Zip Code 98433-2008.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisPO));



                //Lat & Long for Lewis-McChord Communities - McChord Field
                LatLng communitiesMcChord = new LatLng(47.127678,-122.524147);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis-McChord Communities - McChord Field")

                                //description of location
                        .snippet("On-base housing leasing office. Managed by Lewis-McChord Communities.")

                                //LatLng you made before is set as the position of the marker
                        .position(communitiesMcChord));



                //Lat & Long for Lewis-McChord Communities - Lewis Main
                LatLng communitiesLewis = new LatLng(47.090248,-122.594971);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis-McChord Communities - Lewis Main")

                                //description of location
                        .snippet("On-base housing leasing office.")

                                //LatLng you made before is set as the position of the marker
                        .position(communitiesLewis));



                //Lat & Long for Lewis Main Chapel
                LatLng lewisMainChapel = new LatLng(47.091492,-122.612740);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Main Chapel")

                                //description of location
                        .snippet("Lewis Main Chapel, managed by the JBLM Chaplains Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisMainChapel));



                //Lat & Long for Lewis North Chapel
                LatLng lewisNorthChapel = new LatLng(47.121948,-122.599915);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis North Chapel")

                                //description of location
                        .snippet("Lewis North Chapel, managed by the JBLM Chaplains Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisNorthChapel));



                //Lat & Long for Lodging - Evergreen Inn
                LatLng evergreenInn = new LatLng(47.143539,-122.495155);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lodging - Evergreen Inn")

                                //description of location
                        .snippet("Evergreen Inn is managed by IHG Army Hotels.")

                                //LatLng you made before is set as the position of the marker
                        .position(evergreenInn));



                //Lat & Long for Lodging - Rainier Inn
                LatLng rainierInn = new LatLng(47.090454,-122.601379);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lodging - Rainier Inn")

                                //description of location
                        .snippet("Rainier Inn is managed by IHG Army Hotels.")

                                //LatLng you made before is set as the position of the marker
                        .position(rainierInn));



                //Lat & Long for McChord Chapel #1
                LatLng mcChordChapel1 = new LatLng(47.132156,-122.485603);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Chapel #1")

                                //description of location
                        .snippet("McChord Chapel #1, managed by the JBLM Chaplains Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordChapel1));



                //Lat & Long for McChord Chapel #2
                LatLng mcChordChapel2 = new LatLng(47.131775,-122.485680);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Chapel #2")

                                //description of location
                        .snippet("McChord Chapel #2, managed by the JBLM Chaplains Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordChapel2));



                //Lat & Long for McChord Chapel Support Center
                LatLng mcChordChapelSupportCenter = new LatLng(47.132870,-122.487953);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Chapel Support Center")

                                //description of location
                        .snippet("McChord Chapel Support Center, managed by the JBLM Chaplains Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordChapelSupportCenter));



                //Lat & Long for McChord Education Center
                LatLng mcChordEducationCenter = new LatLng(47.122128,-122.504112);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Education Center")

                                //description of location
                        .snippet("McChord Field Force Development Flight provides Air Force career " +
                                "development via training, testing, and advising re: civilian education " +
                                "opportunities at JBLM. Advising, college classes, and testing are " +
                                "offered at this location (family member academic advising is available " +
                                "at Stone Education Center on Lewis Main.)")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordEducationCenter));



                //Lat & Long for McChord Field Library
                LatLng mcChordFieldLibrary = new LatLng(47.122120,-122.503998);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Field Library")

                                //description of location
                        .snippet("McChord Field Library is located on the first floor, and is operated " +
                                "by JBLM Libraries. Services include computer and internet access/wi-fi," +
                                " wireless printing, copier/scanner equipment, books, e-books, magazines, " +
                                "music, DVDs, kids' storytime, and more.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordFieldLibrary));



                //Lat & Long for McChord Post Office
                LatLng mcChordPO = new LatLng(47.134315,-122.487816);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Post Office")

                                //description of location
                        .snippet("Zip Code 98438-9998.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordPO));



                //Lat & Long for McChord Theater
                LatLng mcChordTheater1 = new LatLng(47.133724,-122.488426);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Theater")

                                //description of location
                        .snippet("McChord Theater can be reserved for unit training and events. " +
                                "Free weekend movies, cash-only concessions, provided by JBLM MWR.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordTheater1));



                //Lat & Long for Parent Central - Lewis Main
                LatLng parentCentralLewisMain = new LatLng(47.084839,-122.594322);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Parent Central - Lewis Main")

                                //description of location
                        .snippet("Child, Youth & School Services information and assistance.")

                                //LatLng you made before is set as the position of the marker
                        .position(parentCentralLewisMain));



                //Lat & Long for Parent Central - McChord Field
                LatLng parentCentralMcChordField = new LatLng(47.123257,-122.497139);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Parent Central - McChord Field")

                                //description of location
                        .snippet("Parent Central provides military Child, Youth & School Services information and assistance.")

                                //LatLng you made before is set as the position of the marker
                        .position(parentCentralMcChordField));



                //Lat & Long for Provost Marshal Office
                LatLng provostMarshalOffice = new LatLng(47.091881,-122.611275);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Provost Marshal Office")

                                //description of location
                        .snippet("Police services, desk operations lost & found.")

                                //LatLng you made before is set as the position of the marker
                        .position(provostMarshalOffice));



                //Lat & Long for Soldier's Chapel
                LatLng soldierChapel = new LatLng(47.074436,-122.586678);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Soldier's Chapel")

                                //description of location
                        .snippet("Soldier's Chapel, managed by the JBLM Chaplains Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(soldierChapel));



                //Lat & Long for Soldier & Family Assistance Center
                LatLng soldierFamilyAssistanceCenter = new LatLng(47.105701,-122.552536);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Soldier & Family Assistance Center")

                                //description of location
                        .snippet("Soldier & Family Assistace Center, or SFAC, provides specialized" +
                                " support to Wounded Warrior, Warriors in Transition, and their Families while ill or injured service members heal, " +
                                "and as they prepare for transition back to their military career or into the civilian workforce.")

                                //LatLng you made before is set as the position of the marker
                        .position(soldierFamilyAssistanceCenter));



                //Lat & Long for Stone Education Center
                LatLng stoneEducation = new LatLng(47.095341,-122.575600);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Stone Education Center")

                                //description of location
                        .snippet("David L. Stone Education Center provides space for college classes, " +
                                "military training, service member and family member academic advising, " +
                                "on-site advising and administration for several local colleges offering " +
                                "degree programs on JBLM, and a computer lab on Lewis Main.")

                                //LatLng you made before is set as the position of the marker
                        .position(stoneEducation));



                //Lat & Long for Raindrops & Rainbows
                LatLng raindropsRainbows = new LatLng(47.112549,-122.592033);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Raindrops & Rainbows")

                                //description of location
                        .snippet("Raindrops & Rainbows Parent & Child Activity Center provides free, interactive " +
                                "learning and play opportunities for children ages 5 and under, and their parents.")

                                //LatLng you made before is set as the position of the marker
                        .position(raindropsRainbows));



                //Lat & Long for Space-A Travel
                LatLng spaceATravel = new LatLng(47.150223,-122.484245);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Space-A Travel")

                                //description of location
                        .snippet("Space-available travel info is available on the JBLM Passenger Terminal website. " +
                                "The terminal also posts 72-hour flight outlook on Facebook.")

                                //LatLng you made before is set as the position of the marker
                        .position(spaceATravel));



                //Lat & Long for USO NW - Shali Center
                LatLng uSOShaliCenter = new LatLng(47.150936,-122.484711);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("USO NW - Shali Center")

                                //description of location
                        .snippet("Shali Center</a>. Lounge area, TV, snack bar, computer with internet. Operated by USO Northwest.")

                                //LatLng you made before is set as the position of the marker
                        .position(uSOShaliCenter));



                //Lat & Long for Waller Hall
                LatLng wallerHall = new LatLng(47.089241,-122.597038);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Waller Hall")

                                //description of location
                        .snippet("Waller Hall is a one-stop-shop for new arrivals and out-processing, offering " +
                                "access to many of the Army Community Services (ACS) and Army Directorate of " +
                                "Human Resources (DHR) resources required by arriving or departing service members and families.")

                                //LatLng you made before is set as the position of the marker
                        .position(wallerHall));



                //Lat & Long for Visitor Center - Lewis Main
                LatLng visitorLewisMain = new LatLng(47.101566,-122.588028);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Visitor Center - Lewis Main")

                                //description of location
                        .snippet("Lewis Main Visitor Center, operated by JBLM DES Provost Marshal Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(visitorLewisMain));



                //Lat & Long for Visitor Center - McChord Field
                LatLng visitorMcChord = new LatLng(47.137348,-122.500877);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Visitor Center - McChord Field")

                                //description of location
                        .snippet("McChord Visitor Center, operated by JBLM DES Provost Marshal Office.")

                                //LatLng you made before is set as the position of the marker
                        .position(visitorMcChord));



                //Lat & Long for Lewis Main USPS
                LatLng lewisUSPS = new LatLng(47.134315,-122.487946);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Main USPS")

                                //description of location
                        .snippet(".")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisUSPS));



                //Lat & Long for Beechwood Elementary School
                LatLng beechwoodElementarySchool = new LatLng(47.120350,-122.587982);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Beechwood Elementary School")

                                //description of location
                        .snippet("Beechwood Elementary School.")

                                //LatLng you made before is set as the position of the marker
                        .position(beechwoodElementarySchool));



                //Lat & Long for Carter Lake Elementary School
                LatLng carterLakeElementary = new LatLng(47.128120,-122.520996);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Carter Lake Elementary School")

                                //description of location
                        .snippet("Carter Lake Elementary School.")

                                //LatLng you made before is set as the position of the marker
                        .position(carterLakeElementary));



                //Lat & Long for Clarkmoor Elementary School
                LatLng clarkmoorElementary = new LatLng(47.087708,-122.604050);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Clarkmoor Elementary School")

                                //description of location
                        .snippet("Clarkmoor Elementary School.")

                                //LatLng you made before is set as the position of the marker
                        .position(clarkmoorElementary));



                //Lat & Long for Evergreen Elementary School
                LatLng evergreenElementary = new LatLng(47.114414,-122.560524);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Evergreen Elementary School")

                                //description of location
                        .snippet("Evergreen Elementary School.")

                                //LatLng you made before is set as the position of the marker
                        .position(evergreenElementary));



                //Lat & Long for Greenwood Elementary School
                LatLng greenwoodElementary = new LatLng(47.104744,-122.571022);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Greenwood Elementary School")

                                //description of location
                        .snippet("Greenwood Elementary School.")

                                //LatLng you made before is set as the position of the marker
                        .position(greenwoodElementary));



                //Lat & Long for Hillside Elementary School
                LatLng hillsideElementary = new LatLng(47.132458,-122.495667);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Hillside Elementary School")

                                //description of location
                        .snippet("Hillside Elementary School.")

                                //LatLng you made before is set as the position of the marker
                        .position(hillsideElementary));



                //Lat & Long for Adventures Unlimited
                LatLng adventuresUnlimited = new LatLng(47.137047,-122.491409);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Adventures Unlimited")

                                //description of location
                        .snippet("Adventures Unlimited is operated by JBLM MWR Outdoor Recreation." +
                                "Outdoor gear for sale, equipment rentals, activities and facilities information.")

                                //LatLng you made before is set as the position of the marker
                        .position(adventuresUnlimited));



                //Lat & Long for AFC Arena
                LatLng aFCArena = new LatLng(47.087513,-122.591583);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("AFC Arena")

                                //description of location
                        .snippet("Army Family Covenant Arena</a> offers indoor roller-skating and roller-blading, " +
                                "including skate rentals. A Battle Bean cafe is also located inside.")

                                //LatLng you made before is set as the position of the marker
                        .position(aFCArena));



                //Lat & Long for American Lake Conference Center
                LatLng americanLakeConference = new LatLng(47.110229,-122.580002);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("American Lake Conference Center")

                                //description of location
                        .snippet("The American Lake Conference Center is a multi-functional banquet, conference and event facility.")

                                //LatLng you made before is set as the position of the marker
                        .position(americanLakeConference));



                //Lat & Long for Arts & Crafts Center
                LatLng artsCraft = new LatLng(47.141613,-122.493210);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Arts & Crafts Center")

                                //description of location
                        .snippet("Arts & Crafts center contains a do-it-yourself matting and framing workshop and " +
                                "a customization shop offering custom framing, engraving, and embroidery services, " +
                                "and an assortment of local and customized gifts for sale.")

                                //LatLng you made before is set as the position of the marker
                        .position(artsCraft));



                //Lat & Long for Auto Skills Development Center
                LatLng autoSkills = new LatLng(47.090801,-122.621544);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Auto Skills Development Center")

                                //description of location
                        .snippet("Auto Skills Development Center offers diagnostic services and inspections, " +
                                "do-it-yourself work space, and maintenance classes.")

                                //LatLng you made before is set as the position of the marker
                        .position(autoSkills));



                //Lat & Long for Bistro at Russell Landing
                LatLng bistroRussell = new LatLng(47.123623,-122.578712);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Bistro at Russell Landing")

                                //description of location
                        .snippet("Offers indoor or patio dining on American Lake on Lewis North. " +
                                "Private dining area available for meetings or special events.")

                                //LatLng you made before is set as the position of the marker
                        .position(bistroRussell));



                //Lat & Long for Cannon Gift Shop
                LatLng cannon = new LatLng(47.097164,-122.615089);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Cannon Gift Shop")

                                //description of location
                        .snippet("Cannon Gift Shop is located inside the Lewis Army Museum.")

                                //LatLng you made before is set as the position of the marker
                        .position(cannon));



                //Lat & Long for McChord Club & Community Center
                LatLng mcChordClub = new LatLng(47.135418,-122.496178);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Club & Community Center")

                                //description of location
                        .snippet("The McChord Collocated Club includes conference and event space, " +
                                "the Globemaster Grill, the McChord Community Center the Enlisted " +
                                "Heritage Room and Red Baron (Officers) Lounge, and a barber shop.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordClub));



                //Lat & Long for Cascade Community Center
                LatLng cascadeCenter = new LatLng(47.085533,-122.604408);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Cascade Community Center")

                                //description of location
                        .snippet("Includes conference and event space, Heroes Sports Lounge, and a barber shop.")

                                //LatLng you made before is set as the position of the marker
                        .position(cascadeCenter));



                //Lat & Long for Lewis Community Spouses Club cottage
                LatLng lewisSpouseCottage = new LatLng(47.093388,-122.615402);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Community Spouses Club Cottage")

                                //description of location
                        .snippet("Lewis Community Spouses Club.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisSpouseCottage));



                //Lat & Long for Lewis Main Thrift Shop
                LatLng lewisThrift = new LatLng(47.091488,-122.605377);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Main Thrift Shop")

                                //description of location
                        .snippet("Lewis Main Thrift Shop.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisThrift));



                //Lat & Long for Lewis POV Resale Lot
                LatLng lewisPOVResale = new LatLng(47.098549,-122.613098);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis POV Resale Lot")

                                //description of location
                        .snippet("POV Resale Lot (for display/sale of personally owned vehicles). " +
                                "Managedby Northwest Adventure Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisPOVResale));



                //Lat & Long for Russell Landing Marina
                LatLng russellMarina = new LatLng(47.123474,-122.579170);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Russell Landing Marina")

                                //description of location
                        .snippet("Marina provides boat moorage and dry slips; boat, canoe and kayak " +
                                "rentals at American Lake.")

                                //LatLng you made before is set as the position of the marker
                        .position(russellMarina));



                //Lat & Long for McChord Auto Center
                LatLng mcChordAuto = new LatLng(47.141293,-122.493225);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Auto Center")

                                //description of location
                        .snippet("McChord Auto Center offers diagnostic services and inspections, " +
                                "do-it-yourself work space, and maintenance classes.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordAuto));



                //Lat & Long for McChord POV Resale Lot
                LatLng mcChordPOVResale = new LatLng(47.123371,-122.498482);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord POV Resale Lot")

                                //description of location
                        .snippet("POV Resale Lot (for display/sale of personally owned vehicles)." +
                                " Managed by Northwest Adventure Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordPOVResale));



                //Lat & Long for McChord Thrift Shop
                LatLng mcChordThrift = new LatLng(47.136776,-122.491112);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Thrift Shop")

                                //description of location
                        .snippet("McChord Thrift Shop and Airmen's Attic is operated by the " +
                                "McChord Officers Spouses Club.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordThrift));



                //Lat & Long for MWR Fest Tent
                LatLng festTent = new LatLng(47.087158,-122.593605);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("MWR Fest Tent")

                                //description of location
                        .snippet("Fest Tent is a semi-permanent, weather-protected facility used to host a " +
                                "variety of activities throughout the year, including information expos, " +
                                "fairs, bazaars, and other special events.")

                                //LatLng you made before is set as the position of the marker
                        .position(festTent));



                //Lat & Long for Nelson Recreation Center
                LatLng nelsonRec = new LatLng(47.085743,-122.571297);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Nelson Recreation Center")

                                //description of location
                        .snippet("Pool tables, video games, computer&amp; wi-fi access, movie & " +
                                "TV rooms, ballroom, pavillion, special events.")

                                //LatLng you made before is set as the position of the marker
                        .position(nelsonRec));



                //Lat & Long for Northwest Adventure Center
                LatLng nWAdventure = new LatLng(47.108612,-122.583969);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Northwest Adventure Center")

                                //description of location
                        .snippet("Northwest Adventure Center is operated by JBLM MWR Outdoor Recreation. At this " +
                                "location: outdoor gear for sale, equipment rentals, scuba shop, " +
                                "activities and facilities information, and NW Adventure tours.")

                                //LatLng you made before is set as the position of the marker
                        .position(nWAdventure));



                //Lat & Long for Off Road Vehicle Park
                LatLng offRoadVehicle = new LatLng(47.054073,-122.605316);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Off Road Vehicle Park")

                                //description of location
                        .snippet("Off Road Vehicle Park is open for recreational use of All Terrain " +
                                "Vehicles (ATVs) and dirt bikes. ATV rentals available.")

                                //LatLng you made before is set as the position of the marker
                        .position(offRoadVehicle));



                //Lat & Long for Paintball
                LatLng paintball = new LatLng(47.104149,-122.599480);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Paintball")

                                //description of location
                        .snippet("Recreational paintball range.")

                                //LatLng you made before is set as the position of the marker
                        .position(paintball));



                //Lat & Long for The Pet Brigade
                LatLng petBrigade = new LatLng(47.096466,-122.619171);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("The Pet Brigade")

                                //description of location
                        .snippet("Offers daytime and extended on-site pet boarding and day car, " +
                                "grooming, obedience classes and other services on JBLM in " +
                                "partnership with JBLM DFMWR.")

                                //LatLng you made before is set as the position of the marker
                        .position(petBrigade));



                //Lat & Long for Rifle & Pistol Range
                LatLng riflePistol = new LatLng(47.050095,-122.555023);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Rifle & Pistol Range")

                                //description of location
                        .snippet("Range 15 rifle & pistol range offers recreational target shooting " +
                                "on paper and action targets, at distances of 10 to 300 yards.")

                                //LatLng you made before is set as the position of the marker
                        .position(riflePistol));



                //Lat & Long for RV & Boat Storage - Lewis North
                LatLng lewisRVStorage = new LatLng(47.120571,-122.497566);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("RV & Boat Storage - Lewis North")

                                //description of location
                        .snippet("Long Term Storage Lot (for RVs, boats, etc.).")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisRVStorage));



                //Lat & Long for Scout Hut
                LatLng scoutHut = new LatLng(47.110641,-122.576897);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Scout Hut")

                                //description of location
                        .snippet("The Scout Hut is located at Building 8094; NCO Beach Rd, Lewis " +
                                "North. Phone: (253) 966-6150. Four group of BSA use the hut:Cub " +
                                "Scout, Pack 462: meets Tuesdays @ 6:30PM Boy Scout, Troop 62: meets" +
                                " Wednesdays @ 7PM Boy Scout, Crew 62: meets Thursdays @ 7PM Cub Scout," +
                                " Pack 461: meets Fridays at 6:30PM.")

                                //LatLng you made before is set as the position of the marker
                        .position(scoutHut));



                //Lat & Long for Shotgun Shooting Complex
                LatLng shotgunShooting = new LatLng(47.060848,-122.589516);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Shotgun Shooting Complex")

                                //description of location
                        .snippet("Trap & Skeet, archery.")

                                //LatLng you made before is set as the position of the marker
                        .position(shotgunShooting));



                //Lat & Long for Sounders Lanes Bowling Center
                LatLng sounderBowl = new LatLng(47.133526,-122.489357);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Sounders Lanes Bowling Center")

                                //description of location
                        .snippet("Sounders Lanes bowling center hosts leagues, birthday parties, " +
                                "open bowling. Pro shop, Strike Zone snack bar located inside.")

                                //LatLng you made before is set as the position of the marker
                        .position(sounderBowl));



                //Lat & Long for Tower Gift Shop
                LatLng towerGift = new LatLng(47.121929,-122.494362);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Tower Gift Shop")

                                //description of location
                        .snippet("Tower Gift Shop is located inside the McChord Air Museum.")

                                //LatLng you made before is set as the position of the marker
                        .position(towerGift));



                //Lat & Long for Bowl Arena Lanes
                LatLng bowlArena = new LatLng(47.087669,-122.593452);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Bowl Arena Lanes")

                                //description of location
                        .snippet("Bowl Arena Lanes bowling center hosts leagues, birthday parties, " +
                                "open bowling. Pro shop, Strike Zone cafe located inside.")

                                //LatLng you made before is set as the position of the marker
                        .position(bowlArena));



                //Lat & Long for Warrior Zone
                LatLng warriorZone = new LatLng(47.128151,-122.603226);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Warrior Zone")

                                //description of location
                        .snippet("Warrior Zone recreation center. The Zone restaurant, Battle Bean " +
                                "cafe, and JBLM BOSS office located inside. Also features pool tables," +
                                " video games, computer & wi-fi access, movie &amp; TV room, special events.")

                                //LatLng you made before is set as the position of the marker
                        .position(warriorZone));



                //Lat & Long for Ways and Means Gift Shop
                LatLng wayMeansGift = new LatLng(47.093418,-122.615227);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Ways and Means Gift Shop")

                                //description of location
                        .snippet("The Ways and Means Gift Shop is located inside the spouses club " +
                                "cottage, and is operated by Lewis Community Spouses Club.")

                                //LatLng you made before is set as the position of the marker
                        .position(wayMeansGift));



                //Lat & Long for Movie Theater
                LatLng mcChordTheater = new LatLng(47.133598,-122.488426);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Movie Theater")

                                //description of location
                        .snippet("McChord Movie Theater.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordTheater));



                //Lat & Long for Movie Theater
                LatLng movieTheater = new LatLng(47.087452,-122.597649);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Lewis Main Movie Theater")

                                //description of location
                        .snippet("Reel Time movies at Carey Theater.")

                                //LatLng you made before is set as the position of the marker
                        .position(movieTheater));



                //Lat & Long for Housing Services Office - Lewis Main
                LatLng lewisHousingServices = new LatLng(47.090225,-122.595276);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Housing Services Office - Lewis Main")

                                //description of location
                        .snippet("JBLM Communities on and off base housing office.")

                                //LatLng you made before is set as the position of the marker
                        .position(lewisHousingServices));



                //Lat & Long for Housing Office - McChord Field
                LatLng mcChordHousingOffice = new LatLng(47.127541,-122.524124);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Housing Office - McChord Field")

                                //description of location
                        .snippet("McChord on and off base housing.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordHousingOffice));



                //Lat & Long for Beachwood neighborhood
                LatLng beachwoodNeighborhood = new LatLng(47.114445,-122.589096);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Beachwood Neighborhood")

                                //description of location
                        .snippet("Beachwood Neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(beachwoodNeighborhood));



                //Lat & Long for Beachwood II neighborhood
                LatLng beachwood2 = new LatLng(47.124229,-122.583565);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Beachwood II neighborhood")

                                //description of location
                        .snippet("Beachwood II neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(beachwood2));



                //Lat & Long for Eagleview neighborhood
                LatLng eagleviewNeighborhood = new LatLng(47.124519,-122.592484);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Eagleview neighborhood")

                                //description of location
                        .snippet("Eagleview neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(eagleviewNeighborhood));



                //Lat & Long for Hillside neighborhood
                LatLng hillsideNeighborhood = new LatLng(47.100029,-122.585022);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Hillside neighborhood")

                                //description of location
                        .snippet("Hillside neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(hillsideNeighborhood));



                //Lat & Long for Discovery Village neighborhood
                LatLng discoveryVillage = new LatLng(47.106178,-122.564377);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Discovery Village neighborhood")

                                //description of location
                        .snippet("Discovery Village neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(discoveryVillage));



                //Lat & Long for Evergreen neighborhood
                LatLng evergreenNeighborhood = new LatLng(47.109509,-122.561630);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Evergreen neighborhood")

                                //description of location
                        .snippet("Evergreen neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(evergreenNeighborhood));



                //Lat & Long for Parkway neighborhood
                LatLng parkwayNeighborhood = new LatLng(47.100044,-122.589760);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Parkway neighborhood")

                                //description of location
                        .snippet("Parkway neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(parkwayNeighborhood));



                //Lat & Long for Davis Hill neighborhood
                LatLng davisHill = new LatLng(47.098904,-122.597961);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Davis Hill neighborhood")

                                //description of location
                        .snippet("Davis Hill neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(davisHill));



                //Lat & Long for Greenwood neighborhood
                LatLng greenwood = new LatLng(47.094814,-122.609009);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Greenwood neighborhood")

                                //description of location
                        .snippet("Greenwood neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(greenwood));



                //Lat & Long for Clarkdale neighborhood
                LatLng clarkdale = new LatLng(47.082367,-122.600105);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Clarkdale neighborhood")

                                //description of location
                        .snippet("Clarkdale neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(clarkdale));



                //Lat & Long for Madigan neighborhood
                LatLng madiganNeighborhood = new LatLng(-47.099884,122.538094);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Madigan neighborhood")

                                //description of location
                        .snippet("Madigan neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(madiganNeighborhood));



                //Lat & Long for Heartwood neighborhood
                LatLng heartwood = new LatLng(47.131966,-122.531288);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Heartwood neighborhood")

                                //description of location
                        .snippet("Heartwood neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(heartwood));



                //Lat & Long for Carter Lake neighborhood
                LatLng carterLakeNeighborhood = new LatLng(47.131382,-122.522835);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Carter Lake neighborhood")

                                //description of location
                        .snippet("Carter Lake neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(carterLakeNeighborhood));



                //Lat & Long for Cascade Village neighborhood
                LatLng cascadeVillage = new LatLng(47.136608,-122.521164);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Cascade Village neighborhood")

                                //description of location
                        .snippet("Cascade Village neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(cascadeVillage));



                //Lat & Long for Olympic Grove neighborhood
                LatLng olympicGrove = new LatLng(47.126579,-122.520691);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Olympic Grove neighborhood")

                                //description of location
                        .snippet("Olympic Grove neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(olympicGrove));



                //Lat & Long for Meriwether Landing neighborhood
                LatLng meriwetherLanding = new LatLng(47.139687,-122.586433);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Meriwether Landing neighborhood")

                                //description of location
                        .snippet("Meriwether Landing neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(meriwetherLanding));



                //Lat & Long for Town Center neighborhood
                LatLng townCenter = new LatLng(47.091221,-122.595833);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Town Center neighborhood")

                                //description of location
                        .snippet("Town Center neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(townCenter));



                //Lat & Long for Westcott Hill neighborhood
                LatLng westcottHill = new LatLng(47.124840,-122.512512);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Westcott Hill neighborhood")

                                //description of location
                        .snippet("Westcott Hill neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(westcottHill));



                //Lat & Long for The Bricks neighborhood
                LatLng bricksNeighborhood = new LatLng(47.130844,-122.489311);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("The Bricks neighborhood")

                                //description of location
                        .snippet("The Bricks neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(bricksNeighborhood));



                //Lat & Long for Broadmoor neighborhood
                LatLng broadmoor = new LatLng(47.086311,-122.610489);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Broadmoor neighborhood")

                                //description of location
                        .snippet("Broadmoor neighborhood.")

                                //LatLng you made before is set as the position of the marker
                        .position(broadmoor));



                //Lat & Long for Beachwood Child Development Center
                LatLng beachwoodChild = new LatLng(47.113213,-122.592781);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Beachwood Child Development Center")

                                //description of location
                        .snippet("Beachwood Child Development Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(beachwoodChild));



                //Lat & Long for Madigan Child Development Center
                LatLng madiganChildDevelopment = new LatLng(47.104126,-122.555977);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Madigan Child Development Center")

                                //description of location
                        .snippet("Madigan Child Development Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(madiganChildDevelopment));



                //Lat & Long for Madigan Infant & Toddler CDC
                LatLng madiganInfantToddler = new LatLng(47.104931,-122.556267);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Madigan Infant & Toddler CDC")

                                //description of location
                        .snippet("Madigan Infant & Toddler CDC.")

                                //LatLng you made before is set as the position of the marker
                        .position(madiganInfantToddler));



                /*//Lat & Long for
                LatLng  = new LatLng(47.132458,-122.495667);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("")

                                //description of location
                        .snippet(".")

                                //LatLng you made before is set as the position of the marker
                        .position());*/



                //Lat & Long for North Fort Child Development Center
                LatLng northFortChildDevelopment = new LatLng(47.121037,-122.589157);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("North Fort Child Development Center")

                                //description of location
                        .snippet("North Fort Child Development Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(northFortChildDevelopment));



                //Lat & Long for North Fort Outback CDC (kindergarten)
                LatLng northFortOutbackCDC = new LatLng(47.121761,-122.588562);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("North Fort Outback CDC (kindergarten)")

                                //description of location
                        .snippet("North Fort Outback CDC (kindergarten).")

                                //LatLng you made before is set as the position of the marker
                        .position(northFortOutbackCDC));



                //Lat & Long for Warrior Child Development Center
                LatLng warriorChild = new LatLng(47.111195,-122.554024);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Warrior Child Development Center")

                                //description of location
                        .snippet("Warrior Child Development Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(warriorChild));



                //Lat & Long for Hillside Child Development Center
                LatLng hillsideChild = new LatLng(47.104340,-122.567497);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Hillside Child Development Center")

                                //description of location
                        .snippet("Hillside Child Development Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(hillsideChild));



                //Lat & Long for Clarkmoor Child Development Center
                LatLng clarkmoorChild = new LatLng(47.086441,-122.599983);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Clarkmoor Child Development Center")

                                //description of location
                        .snippet("Clarkmoor Child Development Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(clarkmoorChild));



                //Lat & Long for Clarkmoor CDC hourly child care
                LatLng clarkmoorCDCHourly = new LatLng(47.086384,-122.600945);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Clarkmoor CDC hourly child care")

                                //description of location
                        .snippet("Clarkmoor CDC hourly child care.")

                                //LatLng you made before is set as the position of the marker
                        .position(clarkmoorCDCHourly));



                //Lat & Long for McChord Child Development Center
                LatLng mcChordCDC = new LatLng(47.122105,-122.496468);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Child Development Center")

                                //description of location
                        .snippet("McChord Child Development Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordCDC));



                //Lat & Long for McChord Youth Center & School Age Services
                LatLng mcChordYouthCenter = new LatLng(47.129463,-122.522491);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("McChord Youth Center & School Age Services")

                                //description of location
                        .snippet("McChord Youth Center & School Age Services.")

                                //LatLng you made before is set as the position of the marker
                        .position(mcChordYouthCenter));



                //Lat & Long for Hillside Youth Center
                LatLng hillsideTeenZone = new LatLng(47.104603,-122.568390);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Hillside Youth Center")

                                //description of location
                        .snippet("Hillside Youth Center (Teen Zone).")

                                //LatLng you made before is set as the position of the marker
                        .position(hillsideTeenZone));



                //Lat & Long for SKIES Unlimited
                LatLng sKIESUnlimited = new LatLng(47.104691,-122.569496);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("SKIES Unlimited")

                                //description of location
                        .snippet("SKIES, or 'Schools of Knowledge, Inspiration, Exploration, and Skills' offers a range of education and enrichment classes for JBLM youth.")

                                //LatLng you made before is set as the position of the marker
                        .position(sKIESUnlimited));



                //Lat & Long for North Fort School Age Center
                LatLng northFortSchoolAge = new LatLng(47.121426, -122.587791);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("North Fort School Age Center")

                                //description of location
                        .snippet("North School Age Center youth center.")

                                //LatLng you made before is set as the position of the marker
                        .position(northFortSchoolAge));



                //Lat & Long for Cascade School Age Center
                LatLng cascadeSchoolAge = new LatLng(47.085705,-122.602928);

                //Then it gets added here
                map.addMarker(new MarkerOptions()

                        //Name as displayed on map
                        .title("Cascade School Age Center")

                                //description of location
                        .snippet("Cascade School Age Youth Center.")

                                //LatLng you made before is set as the position of the marker
                        .position(cascadeSchoolAge));



            }
            moveCamera();
        }
    }

    /**
     * Moves the camera position to a given target and zoom level
     * Right now camera always default from one position and flys to
     * to new position on each open of map activity.
     */
    private void moveCamera(){
        //Center map on Town Center Neighborhood
        CameraPosition mainCam = new CameraPosition.Builder()
                .target(new LatLng(47.091221,-122.595833)) //town center
                .zoom(11)
                .build();
        //move camera to camera position
        map.animateCamera(CameraUpdateFactory.newCameraPosition(mainCam));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


}
