package controller

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint


import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import com.kms.katalon.core.annotation.Keyword







import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS



import com.kms.katalon.core.testobject.ResponseObject
import groovy.json.JsonSlurper



public class PersonController {
	@Keyword
	List getPersons() {

		ResponseObject response =
				WS.sendRequest(findTestObject('Object Repository/API/GetPersons'))

		WS.verifyResponseStatusCode(response, 200)

		def json = new JsonSlurper()
				.parseText(response.getResponseBodyContent())

		return json.data
	}
}
