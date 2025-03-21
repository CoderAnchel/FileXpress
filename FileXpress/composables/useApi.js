export async function sendData(url, body) {
    try {
        const response = await useFetch(url, {
            method: 'POST',
            body: JSON.stringify(body),
        });

        return response;
    } catch (err) {
        console.error('An unexpected error occurred:', err);
        return { data: null, error: err };
    }
}
