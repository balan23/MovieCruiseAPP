import {TestBed, inject, fakeAsync} from '@angular/core/testing';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {AuthenticationService } from './authentication.service';
import { HttpClientModule } from '@angular/common/http';

const testConfig = {
    addUser:{
        positive:{
            firstName:'Manoblan',
            lastName:'Mayon',
            userId:'bala2020',
            password:'password',
        }
    },
    loginUser:{
        positive:{
            firstName:'Manoblan',
            lastName:'Mayon',
            userId:'bala2020',
            password:'password'
        }
    }
}
describe('AuthenticationService',() =>{
    let authService : AuthenticationService;
    beforeEach( () =>{
        TestBed.configureTestingModule({
            imports:[HttpClientModule,HttpClientTestingModule],
            providers:[AuthenticationService]
        });
        authService = TestBed.get(AuthenticationService);
    });

    it('should create the authentication service ',
        inject([AuthenticationService],(service:AuthenticationService) =>{
            expect(service).toBeTruthy();
        })
    );
    it('should register user data ', fakeAsync(() =>{
        let data = testConfig.addUser.positive;
        inject([AuthenticationService, HttpTestingController],(backend:HttpTestingController) =>{
            const mockReq = backend.expectOne(authService.springEndpoint);
            expect(mockReq.request.url).toEqual(authService.springEndpoint,'Request url shoul dmatch with json server api url');
            expect(mockReq.request.method).toBe('POST','should handle requested method type');
            mockReq.flush(data);
            backend.verify();
        })

        authService.registerUser(data).subscribe( (res:any) => {
            expect(res).toBeDefined();
            expect(res._body).toBe(data, 'Data to be same ');
        });
    } ));

    

    it('should login user data ', fakeAsync(() =>{
        let userData = testConfig.loginUser.positive;
        inject([AuthenticationService, HttpTestingController],(backend:HttpTestingController) =>{
            const mockReq = backend.expectOne(authService.springEndpoint);
            expect(mockReq.request.url).toEqual(authService.springEndpoint,'Request url should match with json server api url');
            expect(mockReq.request.method).toBe('POST','should handle requested method type');
            mockReq.flush(userData);
            backend.verify();
        })
        authService.loginUser(userData).subscribe( (res:any) => {
            expect(res).toBeDefined();
            expect(res._body).toBe(userData, 'Data to be same ');
        });
    } ));


});

