@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="card" style="box-shadow:5px 5px 5px grey">
                <div class="card-header bg-primary" style="box-shadow: 3px 3px 5px grey;">
                    <div class="text-center" style="font-size:30px;color:white">{{ config('app.name') }}</div>
                </div>

                <div class="card-body bg-info" style="padding:80px">
                    <form method="POST" action="{{ route('login') }}">
                        @csrf

                        <div class="form-group row">
                            <div class="col-md-5 mx-auto">
                            <input id="email" type="email" class="form-control @error('email') is-invalid @enderror bg-info border-white" style="border-width:3px;color:white;" placeholder="Email" name="email" value="{{ old('email') }}" required autocomplete="email" autofocus>

                                @error('email')
                                    <span class="invalid-feedback" role="alert">
                                        <strong>{{ $message }}</strong>
                                    </span>
                                @enderror
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-5 mx-auto">
                                <input id="password" type="password" class="form-control @error('password') is-invalid @enderror bg-info border-white" style="border-width:3px;color:white;" placeholder="Password" name="password" required autocomplete="current-password">

                                @error('password')
                                    <span class="invalid-feedback" role="alert">
                                        <strong>{{ $message }}</strong>
                                    </span>
                                @enderror
                            </div>
                        </div>

                        <div class="form-group row mb-0">
                            <div class="col-md-5 mx-auto">
                                <button type="submit" class="btn btn-primary btn-block rounded-pill border-white" style="border-width:2px">
                                    {{ __('Masuk') }}
                                </button>

                                @if (Route::has('register'))
                                    <a class="btn btn-link text-white" href="{{ route('register') }}">
                                        {{ __('Daftar?') }}
                                    </a>
                                @endif
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
