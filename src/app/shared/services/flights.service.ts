import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

import { Tourist } from "../models/tourist";
import { Observable } from "rxjs";
import { Flight } from "../models/flight";

@Injectable({
  providedIn: 'root'
})
export class FlightsService {
  private BASE_URL = "http://localhost:8080/api/flights";

  constructor(private http: HttpClient) { }

  getAllFlights() : Observable<Flight[]> {
    return this.http.get<Flight[]>(this.BASE_URL);
  }

  getFlightById(id: number) : Observable<Flight> {
    const url = `${this.BASE_URL}/${id}`;
    return this.http.get<Flight>(url);
  }

  getTouristsByFlightId(id: number) : Observable<Tourist[]> {
    const url = `${this.BASE_URL}/${id}/tourists`;
    return this.http.get<Tourist[]>(url);
  }

  addTouristToFlight(flightId: number, tourist: Tourist) : Observable<Flight> {
    const url = `${this.BASE_URL}/${flightId}/tourists`;
    return this.http.post<Flight>(url, tourist);
  }

  removeTouristFromFlight(flightId: number, tourist: Tourist) : Observable<Flight> {
    const url = `${this.BASE_URL}/${flightId}/tourists`;
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      body: tourist,
    };
    return this.http.delete<Flight>(url, options);
  }

  addFlight(flight: Flight) : Observable<Flight> {
    return this.http.post<Flight>(this.BASE_URL, flight);
  }

  deleteFlightById(id: number) : Observable<Flight> {
    const url = `${this.BASE_URL}/${id}`;
    return this.http.delete<Flight>(url);
  }
}
