<?php

namespace App\Providers;

use Laravel\Passport\Passport;
use Illuminate\Foundation\Support\Providers\AuthServiceProvider as ServiceProvider;
use Illuminate\Support\Facades\Gate;

class AuthServiceProvider extends ServiceProvider
{
    /**
     * The policy mappings for the application.
     *
     * @var array
     */
    protected $policies = [
        // 'App\Model' => 'App\Policies\ModelPolicy',
    ];

    /**
     * Register any authentication / authorization services.
     *
     * @return void
     */
    public function boot()
    {
        $this->registerPolicies();
        Passport::routes();

        $start = date("Y-m-d H:i:s");
        $end = date("Y-m-d H:i:s", strtotime('+7 day +1 hour +30 minutes +45 seconds', strtotime($start)));
        $expired = \DateTime::createFromFormat("Y-m-d H:i:s", $end);
        Passport::tokensExpireIn($expired);
    }
}
