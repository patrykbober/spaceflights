import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

import { Tourist } from "../models/tourist";
import { Observable } from "rxjs";
import { Flight } from "../models/flight";

@Injectable({
  providedIn: 'root'
})
export class TouristsService {
  private BASE_URL = "http://localhost:8080/api/tourists";

  constructor(private http: HttpClient) { }

  getAllTourists() : Observable<Tourist[]> {
    return this.http.get<Tourist[]>(this.BASE_URL);
  }

  getTouristById(id: number) : Observable<Tourist> {
    const url = `${this.BASE_URL}/${id}`;
    return this.http.get<Tourist>(url);
  }


  getFlightsByTouristId(id: number) : Observable<Flight[]> {
    const url = `${this.BASE_URL}/${id}/flights`;
    return this.http.get<Flight[]>(url);
  }

  addFlightToTourist(touristId: number, flight: Flight) : Observable<Tourist> {
    const url = `${this.BASE_URL}/${touristId}/flights`;
    return this.http.post<Tourist>(url, flight);
  }

  removeFlightFromTourist(touristId: number, flight: Flight) : Observable<Tourist> {
    const url = `${this.BASE_URL}/${touristId}/flights`;
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      body: flight,
    };
    return this.http.delete<Tourist>(url, options);
  }

  addTourist(tourist: Tourist) : Observable<Tourist> {
    return this.http.post<Tourist>(this.BASE_URL, tourist);
  }

  deleteTouristById(id: number) : Observable<Tourist> {
    const url = `${this.BASE_URL}/${id}`;
    return this.http.delete<Tourist>(url);
  }
}
