import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;

import com.amadeus.shopping.FlightOffersSearch;
import com.amadeus.resources.FlightOfferSearch;

public class AmadeusExample {
  public static void main(String[] args) throws ResponseException {
    Amadeus amadeus = Amadeus
            .builder(System.getenv())
            .build();

    FlightOfferSearch[] offers = amadeus.shopping.flightOffersSearch.get(
              Params.with("originLocationCode", "SYD")
                      .and("destinationLocationCode", "BKK")
                      .and("departureDate", "2020-04-01")
                      .and("returnDate", "2020-04-05")
                      .and("adults", 2)
                      .and("max", 3));

    // Get data field from JSON response
	JsonElement result = offers[0].getResponse().getData();

    // Build a new body of type "fligh-offers-pricing"
    JsonObject flightOfferData= new JsonObject();
    flightOfferData.addProperty("type", "flight-offers-pricing");

    // Concatenate the data output from flight offers
    flightOfferData.add("flightOffers", result);

    // Main element for new input JSON is data
    JsonObject flightPricing = new JsonObject();
    flightPricing.add("data", flightOfferData);

    Response response = amadeus.post("/v1/shopping/flight-offers/pricing", flightPricing);
    System.out.println(response.getResult());
  }

}
