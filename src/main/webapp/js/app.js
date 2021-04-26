async function removeProduct(id) {
	let response = await fetch(`/list?id=${id}`, { method: "DELETE" });

		let element = document.getElementById(`${id}`);
}
