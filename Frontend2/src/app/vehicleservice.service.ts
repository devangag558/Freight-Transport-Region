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
    let c = this.http.get<IVehicle[]>('http://localhost:9000/ftr/vehicles');
    console.log(c);
    return c;

  }
  getVehicleByVehicleNumber(id: string): Observable<IVehicle[]> {
    return this.http.get<IVehicle[]>('http://localhost:9000/ftr/vehicles/managed-number/'+id);
  }

  getVehicleByVehicleName(item: string): Observable<IVehicle[]> {
    let c=this.http.get<IVehicle[]>('http://localhost:9000/ftr/vehicles/managed-name/'+item);
    return c;
  }

  removeVehicle(item: string): Observable<string> {
    let param1 = new HttpParams().set('vehicleNumber', item);
    const opt={params:param1};
    let c = this.http.delete<string>("http://localhost:9000/ftr/vehicles/",opt);
    return c;
  }

  addVehicle(vehicle?: IVehicle): Observable<IVehicle[]> {
    console.log("In service",vehicle);
    let c = this.http.post<IVehicle[]>('http://localhost:9000/ftr/vehicles',vehicle);
    console.log(c);
    return c;

  }
}
