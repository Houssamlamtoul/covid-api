import { TestBed } from '@angular/core/testing';

import { LoginAuthInterceptor } from './login-auth.interceptor';

describe('LoginAuthInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      LoginAuthInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: LoginAuthInterceptor = TestBed.inject(LoginAuthInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
