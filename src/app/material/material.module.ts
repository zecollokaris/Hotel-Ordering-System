import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';



@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatButtonModule,
    MatCheckboxModule
  ],
  exports:[
      BrowserAnimationsModule,
      MatFormFieldModule,
      MatInputModule,
      MatSlideToggleModule,
      MatSelectModule,
      MatButtonModule,
      MatCheckboxModule
  ],
  declarations: []
})
export class MaterialModule { }
