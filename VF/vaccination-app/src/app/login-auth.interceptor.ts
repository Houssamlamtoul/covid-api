import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class LoginAuthInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    if(request.url.includes('/user/login')) {
      return next.handle(request);
    }
    else {
      if (sessionStorage.getItem('username') && sessionStorage.getItem('basicauth')) {
        request = request.clone({
          setHeaders: {
            Authorization: sessionStorage.getItem('basicauth') || '{}'
          }
        })
      }
      return next.handle(request);
    }
  }


  // intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
  //   if(localStorage.getItem('token') !==null){
  //     let headers = request.headers     
  //           .append('Authorization', 'Basic '+localStorage.getItem('token'))
  //         const modifiedRequest = request.clone({headers});
  //         return next.handle(modifiedRequest);
  //     }
  //     return next.handle(request);
  // }
}
