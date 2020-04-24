package main

import (
	"fmt"
	"github.com/aws/aws-lambda-go/lambda"
)

type Request struct {
	ID float64 `json:"id"`
	Values string `json:"value"`
}

type Response struct {
	Message string `json:"message"`
	Status bool `json:"Ok"`
}

func Handler(request Request) (Response, error)  {
	return Response{
		Message : fmt.Sprintf("Process Request ID %f", request.ID),
		Status : true,
	}, nil
}

func main()  {
	lambda.Start(Handler)
}