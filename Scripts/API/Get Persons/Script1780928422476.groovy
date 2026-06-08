import controller.PersonController
import com.kms.katalon.core.util.KeywordUtil

PersonController controller = new PersonController()

List persons = controller.getPersons()

Date birthdayStart = Date.parse('yyyy-MM-dd', '1990-01-01')
Date birthdayEnd = Date.parse('yyyy-MM-dd', '2005-12-31')

persons.eachWithIndex { person, index ->

	String gender = person.gender

	if (gender != 'male') {
		KeywordUtil.markFailed(
			"Person ${index + 1} gender mismatch. Expected: male, Actual: ${gender}"
		)
	}

	Date actualBirthday =
			Date.parse('yyyy-MM-dd', person.birthday)

	if (actualBirthday.before(birthdayStart) ||
		actualBirthday.after(birthdayEnd)) {

		KeywordUtil.markFailed(
			"Person ${index + 1} birthday invalid: ${person.birthday}"
		)
	}
}