import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatMenuModule} from '@angular/material/menu';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatTreeModule} from '@angular/material/tree';
import {MatIconModule} from '@angular/material/icon';
import {CdkTreeModule} from '@angular/cdk/tree';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';




@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatButtonModule,
    MatCheckboxModule,
    MatMenuModule,
    MatTooltipModule,
    MatExpansionModule,
    MatTreeModule,
    MatIconModule,
    CdkTreeModule,
    MatTabsModule,
    MatCardModule,
  ],
  exports: [
      BrowserAnimationsModule,
      MatFormFieldModule,
      MatInputModule,
      MatSlideToggleModule,
      MatSelectModule,
      MatButtonModule,
      MatCheckboxModule,
      MatMenuModule,
      MatTooltipModule,
      MatExpansionModule,
      MatTreeModule,
      MatIconModule,
      CdkTreeModule,
      MatTabsModule,
      MatCardModule,
  ],
  declarations: []
})
export class MaterialModule { }
