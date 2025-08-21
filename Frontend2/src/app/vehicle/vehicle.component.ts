import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
// import { Console } from 'console';
import { IVehicle } from '../Poster';
import { VehicleserviceService } from '../vehicleservice.service';

// import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css'],
})
export class VehicleComponent implements OnInit {
  submitted = false;
  adding = false;
  getting = false;
  updating = false;
  deleting = false;
  gettingId = false;
  gettingItem = false;
  vehicleDetails: any[] = [];

  term: IVehicle = new IVehicle();


  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private vehicleservice: VehicleserviceService
  ) {}
  addVehicle!: FormGroup;
  
  stringdelete!: string;
  vehicleNumber='';
  vehicleName='';
  maxLiftingcapacity!: number;
  retireDate!: Date;
  vehicleStatus!: string;
  harborLocation!: string;
  country!: string;

  addingmessage = false;
  updatingmessage = false;
  deletingmessage = false;
  gettingIdmessage = false;
  gettingItemmessage = false;

  ngOnInit(): void {
    console.log("ONINIT");
    this.addVehicle = this.formBuilder.group({
      vehicleNumber: ['', Validators.required],
      vehicleName: ['', Validators.required],
      maxLiftingCapacity: ['', Validators.required],
      retireDate: ['', Validators.required],
      vehicleStatus: ['', Validators.required],
      harborLocation: ['', Validators.required],
      country: ['', Validators.required],
    });
  }

  add() {
    this.submitted = true;
    this.adding = true;
  }
  getAll() {
    this.vehicleservice.getVehicle().subscribe((data) => (this.vehicleDetails = data));
    this.submitted = true;
    this.getting = true;
  }
  update() {
    this.submitted = true;
    this.updating = true;
  }
  delete() {
    this.submitted = true;
    this.deleting = true;
  }
  getById() {
    this.submitted = true;
    this.gettingId = true;
  }
  getByItem() {
    this.submitted = true;
    this.gettingItem = true;
  }
  Back() {
    this.submitted = false;
    this.adding = false;
    this.getting = false;
    this.updating = false;
    this.deleting = false;
    this.gettingId = false;
    this.gettingItem = false;
    this.updatingmessage = false;
    this.deletingmessage = false;
    this.addingmessage = false;
    this.gettingIdmessage = false;
    this.gettingItemmessage = false;
  }

  Submit() {
    console.log(this.addVehicle.getRawValue());
    this.addingmessage = true;
    this.term=this.addVehicle.getRawValue();
    this.vehicleservice.addVehicle(this.term).subscribe({
      next:(data) => {console.log(data)},
      error:err=>{console.log(err.error.text)}});
  }

  deletemessage(v:any) {
    this.deletingmessage = true;
    this.vehicleservice.removeVehicle(this.vehicleNumber).subscribe({
      next:(data) => {console.log(data);this.stringdelete=data},
      error:err=>{console.log(err.error.text)}});
    this.vehicleNumber='';
  }

  getIdmessage(v:any) {
    this.vehicleDetails=[];
    this.gettingIdmessage = true;
    this.vehicleservice.getVehicleByVehicleNumber(v).subscribe((data) => (this.vehicleDetails.push(data)));

  }

  getItemmessage(v:any) {
    this.vehicleDetails=[];
    this.gettingItemmessage = true;
    this.vehicleservice.getVehicleByVehicleName(v).subscribe((data) => (this.vehicleDetails = data));
  }
}
