$(document).ready(function () {
    $('#categories-table').DataTable({
        processing: true,
        info: false,
        "lengthMenu": [5, 10, 20],
        language: {
            emptyTable: "Không có dữ liệu",
            zeroRecords: "Không tìm thấy dữ liệu",
            paginate: {
                first: "Trang đầu",
                previous: "Trang trước",
                next: "Trang sau",
                last: "Trang cuối"
            },
            "search": "Tìm kiếm: ",
            "lengthMenu": "Kết quả hiển thị _MENU_"
        }
    });
});
$(document).ready(function () {
    $('#product-table').DataTable({
        processing: true,
        searching: true,
        info: false,
        "lengthMenu": [5, 10, 20],
        language: {
            emptyTable: "Không có dữ liệu",
            zeroRecords: "Không tìm thấy dữ liệu",
            paginate: {
                first: "Trang đầu",
                previous: "Trang trước",
                next: "Trang sau",
                last: "Trang cuối"
            },
            "search": "Tìm kiếm: ",
            "lengthMenu": "Kết quả hiển thị _MENU_"
        }
    });
});