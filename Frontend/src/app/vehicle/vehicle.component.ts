import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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
  // AddForm!: FormGroup;
  vehicleDetails: any[] = [];
  getVehicleByVehicleNumber: any[] = [];
  getVehicleByVehicleName: any[] = [];

  term: IVehicle = new IVehicle();

  stringdelete: String = '';

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private vehicleservice: VehicleserviceService
  ) {}
  addVehicle!: FormGroup;

  vehicleNumber!: string;
  vehicleName!: string;
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
    this.vehicleservice
      .getVehicle()
      .subscribe((data) => (this.vehicleDetails = data));

    this.vehicleservice
      .getVehicleByVehicleNumber(this.vehicleNumber)
      .subscribe((data) => (this.getVehicleByVehicleNumber = data));

    this.vehicleservice
      .getVehicleByVehicleName(this.vehicleName)
      .subscribe((data) => (this.getVehicleByVehicleName = data));

    this.vehicleservice
      .removeVehicle(this.vehicleNumber)
      .subscribe((data) => (this.stringdelete = data));

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
    this.addingmessage = true;
    console.log(this.term);
    this.vehicleservice.addVehicle(this.term);
  }

  updatemessage() {
    this.updatingmessage = true;
  }

  deletemessage() {
    this.deletingmessage = true;
  }

  getIdmessage() {
    this.gettingIdmessage = true;
  }

  getItemmessage() {
    this.gettingItemmessage = true;
  }
}
