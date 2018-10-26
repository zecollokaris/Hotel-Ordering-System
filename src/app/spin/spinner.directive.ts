import { Directive, Input } from '@angular/core';

@Directive({
  selector: '[appSpinner]'
})
export class SpinnerDirective {
  @Input() show = false;
  constructor(  ) { }

}
