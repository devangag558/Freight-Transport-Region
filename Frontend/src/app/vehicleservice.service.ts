import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IVehicle } from './Poster';

@Injectable({
  providedIn: 'root',
})
export class VehicleserviceService {
  constructor(private http: HttpClient) {}
  id!: any;

  getVehicle(): Observable<IVehicle[]> {
    return this.http.get<IVehicle[]>('http://localhost:9000/ftr/vehicles');
  }
  getVehicleByVehicleNumber(id: string): Observable<IVehicle[]> {
    console.log(id);
    let param1 = new HttpParams().set('vehicleNumber', id);
    return this.http.get<IVehicle[]>(
      'http://localhost:9000/ftr/vehicles/fetchVehicleByVehicleNumber?vehicleNumber=' +
        id
    );
  }

  getVehicleByVehicleName(item: string): Observable<IVehicle[]> {
    console.log(item);
    let param1 = new HttpParams().set('vehicleName', item);
    console.log(param1);
    return this.http.get<IVehicle[]>(
      'http://localhost:9000/ftr/vehicles/fetchVehicleByVehicleName?vehicleName=' +
        item
    );
  }

  removeVehicle(item: string): Observable<String> {
    console.log(item);
    let param1 = new HttpParams().set('vehicleNumber', item);
    return this.http.get<String>(
      'http://localhost:9000/ftr/vehicles?vehicleNumber=' + item
    );
  }

  addVehicle(vehicle?: IVehicle): Observable<IVehicle[]> {
    return this.http.post<IVehicle[]>(
      'http://localhost:9000/ftr/vehicles',
      vehicle
    );
  }
}
