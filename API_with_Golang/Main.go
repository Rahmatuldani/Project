package main

import (
	"fmt"
	"log"
	"net/http"
	"encoding/json"
	"github.com/gorilla/mux"
)

type Article struct {
	Title string `json:"Title"`
	Desc string `json:"Desc"`
	Content string `json:"Content"`
}

type Articles []Article

func allArticles(w http.ResponseWriter, r *http.Request)  {
	articles := Articles{
		Article{
			Title : "Test Title",
			Desc : "Test Desc",
			Content : "Hello World",
		},
	}

	fmt.Printf("All Articles Endpoint hit")
	json.NewEncoder(w).Encode(articles)
}

func homePage(w http.ResponseWriter, r *http.Request)  {
	fmt.Fprintf(w, "Homepage Endpoint hit")
}

func testPostArticles(w http.ResponseWriter, r *http.Request)  {
	fmt.Fprintf(w, "Test Post Endpoint hit")
}

func handleRequests()  {

	myRouter := mux.NewRouter().StrictSlash(true)

	myRouter.HandleFunc("/", homePage)
	myRouter.HandleFunc("/articles", allArticles).Methods("GET")
	myRouter.HandleFunc("/articles", testPostArticles).Methods("POST")
	log.Fatal(http.ListenAndServe(":8081", myRouter))
}

func main(){
	handleRequests()
}